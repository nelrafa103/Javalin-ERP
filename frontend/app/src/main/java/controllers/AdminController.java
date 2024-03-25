package controllers;

import org.eclipse.jetty.server.session.SessionDataStore;
import org.eclipse.jetty.server.session.SessionDataStoreFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

public class AdminController extends BaseController {

    public AdminController(Javalin app) {
        super(app);
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.get("/admin/forms", ctx -> ctx.render("/admin/FormsView.html"));
            app.get("/admin/dashboard", ctx -> ctx.render("/admin/DashboardView.html"));
            app.get("/admin/users", ctx -> ctx.render("/admin/UsersView.html"));
        });

    }
}