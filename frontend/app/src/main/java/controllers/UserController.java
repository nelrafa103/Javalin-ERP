package controllers;

import org.checkerframework.checker.units.qual.s;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import interfaces.Respuesta;
import io.javalin.Javalin;

public class UserController extends BaseController {
    public UserController(Javalin app) {
        super(app);
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.post("/logout", ctx -> {
                ctx.cookieStore().clear();
                // Hay que ver si se puede registrar los logout y login dentro de la app
            });
            app.get("/login", ctx -> ctx.render("/LoginView.html"));
            app.get("/profile", ctx -> ctx.render("/ProfileView.html"));
            app.get("/signup", ctx -> ctx.render("/SignupView.html"));
            app.post("/token", ctx -> {
                Respuesta respuesta = ctx.bodyAsClass(Respuesta.class);
                ctx.sessionAttribute("token", respuesta.getToken());
                ctx.cookie("token", respuesta.getToken());

                System.out.println(respuesta.getToken());
            });
            app.post("/keep", ctx -> {
                // Esta metodo post existe para mantener la sesion activa durante una semana
                // 604800 son la cantidad de segundos en una semana. Entonces habria
                // que comprobar si la cookie existe cuando se accede al formulari o a la parte
                // de admin
                ctx.cookie("alive?", "true", 604800);
            });
        });
    }
}