package org.example;

import controllers.RoleController;
import controllers.WebsocketController;
import grpc.FormGrpc;
import grpc.UsuarioGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.javalin.Javalin;
import io.javalin.community.ssl.SSLPlugin;
import services.BaseService;
import controllers.UserController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import controllers.AdminController;
import controllers.FormController;

public class Main {
    public static void main(String[] args) throws IOException {

        int portGrpc = 9000;

        Server server = ServerBuilder.forPort(portGrpc)
                .addService(new FormGrpc())// indicando el servicio registrado.
                .addService(new UsuarioGrpc())
                .build()
                .start();
        System.out.println("Servidor gRPC iniciando y escuchando en " + portGrpc);

        InputStream cert = null;
        InputStream key = null;

        try{
            cert = new FileInputStream("cert.pem");
            key = new FileInputStream("key.pem");

        }catch (Exception excpt){
            System.out.println("No se pudo encontrar los documentos cert.pem y key.pem para la autentificacion SSL");
            excpt.printStackTrace();
            return;
        }

        InputStream finalCert = cert;
        InputStream finalKey = key;
        SSLPlugin plugin = new SSLPlugin(conf -> {
            conf.sniHostCheck = false;
            conf.pemFromInputStream(finalCert, finalKey, "marielm20");
            conf.sniHostCheck = false;
            conf.insecurePort = 7000;
            conf.securePort = 7001;
        });

        System.out.println("Backend de Projecto Final Nelcido y Miguel");

        // Crear Roles
        crearRoles();

        // Es necesario que la aplicacion verifique los tokens de los usuarios 
        Javalin app = Javalin.create(config -> {
            // COnfiguraciones

            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost();
                });
            });

            config.plugins.register(plugin);

        });

        app.start();

        app.routes(() -> {
            app.get("/", ctx -> {
                Map<String,Object> mapa = new HashMap<>();
                mapa.put("mensaje", "Aplicacion de Projecto Final");
                mapa.put("servicio web", "direccion en aws");
                ctx.json(mapa);
                //ctx.json("Aplicacion de Projecto Final");
            });
        });

        new UserController(app).routas();
        new FormController(app).routas();
        new RoleController(app).routas();
        new WebsocketController(app).routas();
        new AdminController(app).routas();
    }

    // TODO: Agregar la funcionalidad de roles predeterminados a la base de datos
    private static void crearRoles() {
        // Por el momento
        // 0 -> super admin
        // 1 -> Trabajador
    }

}