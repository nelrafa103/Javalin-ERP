/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package frontend;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.javalin.Javalin;
import io.javalin.community.ssl.SSLPlugin;
import io.javalin.config.SizeUnit;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import controllers.AdminController;
import controllers.ErrorController;
import controllers.UserController;
import data.Data;
import data.FormRmGrpc;
import data.UsuarioRnGrpc;
import data.Data.FormInterface;
import interfaces.FormInterfaceFrontend;
import data.Data.FormRequest;
import data.Data.ListaForm;
import data.Data.FormRequest.Builder;
import io.javalin.rendering.template.JavalinThymeleaf;
import controllers.HomeController;
import controllers.FormController;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Empty;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.rpc.context.AttributeContext.Request;

public class App {

    public static void main(String[] args) {

        /*
         * Nota: Para poder hace un fetch es necesario que el protocolo tambien sea
         * https y no http
         */
        // Es necesario que tomes los archivos cert.pem y key.pem y lo lleves a la
        // direccion /etc/ssl de tu maquina
        // para que puedas ejecutar el proyecto, otra cosa para utilizar web workers es
        // necesario que tengas un
        // certificado valido, estos certificados no son validos porque no estan
        // firmados por una entidad certificadora
        // No se como podria hacer para que este certificado sea valido, imagino que si
        // creas un certificado a nombre de un dominio
        // distinto al entrar te diria que es invalido.

        //
        String host = "localhost";
        int puerto = 9000;

        // Abriendo la conectividad
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, puerto)
                .usePlaintext() // configuración para la conexión.
                .build();

        FormRmGrpc.FormRmBlockingStub formInterfaz = FormRmGrpc.newBlockingStub(channel);
        UsuarioRnGrpc.UsuarioRnBlockingStub usuarioInterfaz = UsuarioRnGrpc.newBlockingStub(channel);

        // data. estudianteInterfaz = EstudianteRnGrpc.newBlockingStub(channel);

        InputStream cert = null;
        InputStream key = null;

        try {
            cert = new FileInputStream("cert.pem");
            key = new FileInputStream("key.pem");

        } catch (Exception excpt) {
            System.out.println("No se pudo encontrar los documentos cert.pem y key.pem para la autentificacion SSL");
            excpt.printStackTrace();
            return;
        }

        InputStream finalCert = cert;
        InputStream finalKey = key;
        SSLPlugin plugin = new SSLPlugin(conf -> {
            conf.sniHostCheck = false;
            conf.insecurePort = 8090;
            conf.securePort = 8091;
            conf.pemFromInputStream(finalCert, finalKey, "marielm20");
        });

        var app = Javalin.create(config -> {
            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/public";
                staticFileConfig.location = Location.CLASSPATH;
                staticFileConfig.precompress = false;
                staticFileConfig.aliasCheck = null;
            });

            config.plugins.enableCors(corsContainer -> {
                corsContainer.add(corsPluginConfig -> {
                    corsPluginConfig.anyHost();

                });
            });

            config.plugins.register(plugin);
            config.jetty.multipartConfig.cacheDirectory("c:/temp");
            config.jetty.multipartConfig.maxFileSize(100, SizeUnit.MB);
            config.jetty.multipartConfig.maxInMemoryFileSize(10, SizeUnit.MB);
            config.jetty.multipartConfig.maxTotalRequestSize(1, SizeUnit.GB);

        }).start();

        app.get("/form={userid}", ctx -> {

            Data.ListaForm listaForm = formInterfaz
                    .listFormUsuarioId(Data.FormRequest.newBuilder().setValueStr("64e8eb6cbefc4b6c0eeb6c9p").build());

            List<FormInterfaceFrontend> lista = new ArrayList<>();

            for (Data.FormInterface f : listaForm.getFormList()) {
                FormInterfaceFrontend nuevo = new FormInterfaceFrontend();
                nuevo.setApellido(f.getApellido());
                nuevo.setNombre(f.getNombre());
                nuevo.setIdForm(f.getIdForm());
                nuevo.setNivelAcademico(f.getNivelAcademico());
                lista.add(nuevo);
            }
            ctx.json(lista);

            // ctx.json(resultado);
        });
        app.post("/form/new", ctx -> {
            ByteString foto = null;


            FormInterfaceFrontend nuevo = ctx.bodyAsClass(FormInterfaceFrontend.class);
            System.out.println(nuevo);
       
                formInterfaz.insertForm(Data.FormInterface.newBuilder()
                        .setIdForm(nuevo.getIdForm())
                        .setIdUsuario(nuevo.getIdUsuario())
                        .setNombre(nuevo.getNombre())
                        .setApellido(nuevo.getApellido())
                        .setTelefono(nuevo.getTelefono())
                        .setNivelAcademico(nuevo.getNivelAcademico())
                        .setLatitud(nuevo.getLatitud())
                        .setLongitud(nuevo.getLongitud())
                        .setFoto(ByteString.copyFrom(nuevo.getFoto()))
                        .build());
            

           // ctx.json(new Object());
        });

        app.get("/form/users", ctx -> {
            ListaForm resultado = formInterfaz.listForm(null);

            // System.out.println(resultado.getForm(0));
            List<FormInterfaceFrontend> lista = new ArrayList<>();
            resultado.getFormList().forEach((form) -> {
                FormInterfaceFrontend nuevo = new FormInterfaceFrontend();
                nuevo.setApellido(form.getApellido());
                nuevo.setNombre(form.getNombre());
                nuevo.setIdForm(form.getIdForm());
                nuevo.setNivelAcademico(form.getNivelAcademico());
                lista.add(nuevo);
            });
            ctx.json(lista);

        });

        new AdminController(app).routas();
        new UserController(app).routas();
        new ErrorController(app).routas();
        new HomeController(app).routas();
        new FormController(app).routas();
        JavalinRenderer.register(new JavalinThymeleaf(), ".html");

    }
}