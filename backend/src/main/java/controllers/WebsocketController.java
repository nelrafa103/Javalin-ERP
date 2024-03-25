package controllers;

import interfaces.FormInterface;
import interfaces.MensajeInterface;
import io.javalin.Javalin;
import io.javalin.websocket.WsContext;
import services.DataService;
import services.FormService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebsocketController extends BaseController {

    // Creando el Mapa que contentra los ws context de cada usuario
    private static final Map<WsContext, String> userUsernameMap = new ConcurrentHashMap<>();
    // La manera de ponerle un label a los usuarios conectados
    private static int nextUserNumber = 1;
    // Forma para interactuar con la BD de mongo en el form
    FormService formService = new FormService();

    public WebsocketController(Javalin app) {
        super(app);
    }

    @Override
    public void routas() {
        app.ws("sync", ws -> {

            // Cuando se contectan, creamos el usuario y lo colocamos en el mapa
            ws.onConnect(ctx -> {
                String user = "user" + nextUserNumber;
                userUsernameMap.put(ctx, user);
            });

            // Cuando se Desconectan, quitamos el usuario del mapa
            ws.onClose(ctx -> {
                userUsernameMap.remove(ctx);
            });

            // Cuando mandan un form
            ws.onMessage(ctx -> {
                System.out.println("\n");
                System.out.println("\n");

                System.out.println("\n");
                System.out.println("\n");


                System.out.println(ctx.message());

                System.out.println("\n");
                System.out.println("\n");

                System.out.println("\n");
                System.out.println("\n");

                MensajeInterface mensaje = ctx.messageAsClass(MensajeInterface.class);
                if (mensaje.getTipo().equals("new_form")) {
                    ObjectMapper mapper = new ObjectMapper();
                    List<FormInterface> lista = mapper.convertValue(mensaje.getMensaje(),
                            new TypeReference<List<FormInterface>>() {
                            });
                    System.out.println(lista.get(0));
                    System.out.println(mensaje.getMensaje());

                    HttpClient cliente = HttpClient.newHttpClient();

                    // El primer paso para mapear es utilizar object mapper, sin embargo, al ser un
                    // json con mucho objetos se complica

                    for (FormInterface item : lista) {

                        HttpRequest peticion = HttpRequest.newBuilder().uri(new URI(
                                "https://maps.googleapis.com/maps/api/geocode/json?latlng="
                                        + item.getLatitud().toString() + ","
                                        + item.getLongitud().toString()
                                        + "&key=AIzaSyARGxyXTVxGZkS7QzQ3Cg3DnPmIyNfTjzc"))
                                .GET().build();
                        HttpResponse<String> respuesta = cliente.send(peticion, BodyHandlers.ofString());

                        Map<String, Object> mapa = new ObjectMapper(null).readValue(respuesta.body(), Map.class);
                        Map<Object, Object> resumen = (Map<Object, Object>) mapa.get("plus_code");
                        DataService dataService = new DataService();

                        dataService.addPlace((String) resumen.get("compound_code"),
                                item.getLatitud(),
                                item.getLongitud());

                    }

                    // System.out.println();

                    // formService.((FormInterface) mensaje.getMensaje());
                    formService.insertMany(lista);
                }
                userUsernameMap.keySet().stream().filter(contexto -> ctx.session.isOpen()).forEach(sesion -> {
                    sesion.send(
                            Map.of(
                                    "tipo", mensaje.getTipo(),
                                    "mensaje", mensaje.getMensaje()));

                });
                // ctx.send("Buenos dias");
                // recieveForm(userUsernameMap.get(ctx),
                // ctx.messageAsClass(FormInterface.class));
            });

        });
    }

    /*
     * Tipos de actualizaciones:
     * - count_forms
     * - count_adress
     * - count_users
     * - new_form
     * - new_user
     * - update_user
     * 
     */
    // TODO: Crear una funcion que toma el ctx.message, con eso obtenga el
    // formInterface y con FormService cree un form
    void recieveForm(String user, FormInterface form) {
        formService.insertOne(form);
    }
}
