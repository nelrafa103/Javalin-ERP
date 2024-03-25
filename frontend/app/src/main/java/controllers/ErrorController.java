package controllers;

import java.util.HashMap;
import java.util.Map;

import io.javalin.Javalin;

public class ErrorController extends BaseController {

    public ErrorController(Javalin app) {
        super(app);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {

        app.routes(
                () -> {
                    app.get("/no-autorizado", ctx -> {

                        Map<String, Object> model = new HashMap<>();
                        model.put("codigo", "401 - No autorizado");
                        ctx.render("/HandlerView.html", model);
                    });
                    app.get("/no-encontrado", ctx -> {

                        Map<String, Object> model = new HashMap<>();
                        model.put("codigo", "404 - No Encontrado");
                        ctx.render("/HandlerView.html");
                    });
                });
    }

}
