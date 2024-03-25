package controllers;

import io.javalin.Javalin;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import interfaces.FormInterface;
import services.DataService;
import services.FormService;

/*
 * Controladores son los encargados de recibir las peticiones del cliente y enviarlas al servicio correspondiente
 */
public class FormController extends BaseController {

    FormService formService = new FormService();

    public FormController(Javalin app) {
        super(app);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.post("/form/new", ctx -> {
                FormInterface nuevo = ctx.bodyAsClass(FormInterface.class);
                Object resultado = formService.insertOne(nuevo);
                HttpClient cliente = HttpClient.newHttpClient();
                HttpRequest peticion = HttpRequest.newBuilder().uri(new URI(
                        "https://maps.googleapis.com/maps/api/geocode/json?latlng=19.4900957,-70.7417021&key=AIzaSyARGxyXTVxGZkS7QzQ3Cg3DnPmIyNfTjzc"))
                        .GET().build();
                HttpResponse<String> respuesta = cliente.send(peticion, BodyHandlers.ofString());
                if (respuesta.statusCode() == 200) {
                    // El primer paso para mapear es utilizar object mapper, sin embargo, al ser un json con mucho objetos se complica
                    Map<String, Object> mapa = new ObjectMapper(null).readValue(respuesta.body(), Map.class);
                    // Por esta razon se utiliza un mapa de objetos para poder acceder a los datos, se hace una conversion de tipo (100% necesario)
                    Map<Object, Object> resumen = (Map<Object, Object>) mapa.get("plus_code");
                    DataService dataService = new DataService();
                    dataService.addPlace((String) resumen.get("compound_code"),nuevo.getLatitud(),nuevo.getLongitud());
                   // System.out.println();


                }
                 ctx.json(resultado);
            });

            // obtener formularios por id del usuario que lo tomo

            /*
             * Esta parte es requiremiento camacho, necesitamos tener esta funcionalidad
             * rest API y grpc
             */

            
            app.get("/form/user={id}", ctx -> {
                Object resultado = formService.readOneById(ctx.pathParam("id"));
                ctx.json(resultado);
            });

            app.get("/form/name={id}", ctx -> {
                Object resultado = formService.readOneByName(ctx.pathParam("id"));
                ctx.json(resultado);
            } );
            app.get("/form/all", ctx -> {
                Object resultado = formService.readAll();
                ctx.json(resultado);
            });
        });
    }

}