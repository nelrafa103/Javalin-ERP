package controllers;

import interfaces.FormInterface;
import interfaces.RolesInterface;
import io.javalin.Javalin;
import services.FormService;
import services.RoleService;

/*
 * Controladores son los encargados de recibir las peticiones del cliente y enviarlas al servicio correspondiente
 */
public class RoleController extends BaseController {

    RoleService roleService = new RoleService();

    public RoleController(Javalin app) {
        super(app);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.post("/role/new", ctx -> {
                RolesInterface nuevo = ctx.bodyAsClass(RolesInterface.class);
                Object resultado = roleService.insertOne(nuevo);
                ctx.json(resultado);
            });


            // obtener formularios por id del usuario que lo tomo 

            /*
             * Esta parte es requiremiento camacho, necesitamos tener esta funcionalidad rest API y grpc 
             */
            app.get("/role/id={id}", ctx -> {
                Object resultado = roleService.readOne(Integer.getInteger(ctx.pathParam("id")));
                ctx.json(resultado);
            });


            app.get("/role/all", ctx -> {
                Object resultado = roleService.readAll();
                ctx.json(resultado);
            });
        });
    }

}