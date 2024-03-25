package controllers;

import io.javalin.Javalin;

public class HomeController extends BaseController   {

    public HomeController(Javalin app) {
        super(app);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.get("/", ctx -> ctx.render("/HomeView.html"));
            app.get("/grpc", ctx -> ctx.render("/grpcView.html"));
        });
    }
    
}
