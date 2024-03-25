package controllers;

import java.util.HashMap;
import java.util.Map;

import io.javalin.Javalin;
import services.DataService;

public class AdminController extends BaseController {

    public AdminController(Javalin app) {
        super(app);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.get("/panel", ctx -> {
                DataService dataService = new DataService();

                Map<String, Object> mapa = new HashMap<>();
                mapa.put("lista_lugares", dataService.getAllPlaces());
                mapa.put("cantidad_usuarios", dataService.getAllUsers());
                mapa.put("cantidad_formularios", dataService.getAllForms());
                mapa.put("cantidad_lugares", dataService.getCountPlaces());

                ctx.json(mapa);
            });
        });
    }

}
