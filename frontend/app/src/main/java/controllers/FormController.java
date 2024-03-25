package controllers;

import java.util.HashMap;
import java.util.Map;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormController extends BaseController {
    public FormController(Javalin app) {
        super(app);
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.get("/pre", ctx -> ctx.render("/PreView.html"));


            app.get("/camara", ctx -> ctx.render("/CamaraView.html"));
            app.before("/form", ctx -> {

            });
            app.get("/form", ctx -> {
                // System.out.println(ctx.sessionAttribute("formulario-guardado"));
                Map <String, String> mapa = new HashMap<>();
                mapa.put("nombres", ctx.cookie("nombre"));
                mapa.put("apellidos", ctx.cookie("apellido"));
                mapa.put("sector", ctx.cookie("sector"));
                mapa.put("nivel", ctx.cookie("nivel"));
             //   System.out.println(mapa);
                ctx.render("/FormView.html", mapa);
            });

            app.post("/edit", ctx -> {
                Map<String, String> mapa = new ObjectMapper(null).readValue(ctx.body(), Map.class);
                ctx.cookie("nombre", mapa.get("nombres"));
                ctx.cookie("apellido", mapa.get("apellidos"));
                ctx.cookie("sector", mapa.get("sector"));
                ctx.cookie("nivel", mapa.get("nivel"));
                //System.out.println(mapa);
                ctx.json(mapa);
            });
        });
    }
}