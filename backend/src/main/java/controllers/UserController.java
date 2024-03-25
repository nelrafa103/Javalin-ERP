package controllers;

import io.javalin.Javalin;
import interfaces.Login;
import interfaces.UsuarioInterface;
import services.UserService;

import java.util.HashMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class UserController extends BaseController {

    public UserController(Javalin app) {
        super(app);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {
        app.routes(() -> {
            app.post("/login", ctx -> {
                Login login = ctx.bodyAsClass(Login.class);
                UserService loginService = new UserService();
                UsuarioInterface nuevo = loginService.login(login.getUsername(), login.getPassword());


               // Encrypt
                System.out.println("Porque" + nuevo.getApellido());
                if (nuevo != null) {
                    try {

                        Algorithm algorithm = Algorithm.HMAC256("secret");
                        String token = JWT.create()
                                .withClaim("id", nuevo.getIdUsuario())
                                .withClaim("rol", nuevo.getIdRole())
                                .sign(algorithm);

                        System.out.println(token);

                        ctx.json(new HashMap<String, String>() {
                            {
                                put("token", token);
                            }
                        });
                        ctx.status(200);
                    } catch (JWTCreationException exception) {
                        throw new Exception("No se podido crear un jwt para el login", exception);
                    }
                }
            });

            app.post("/logout", ctx -> {
                /*
                 * En este caso se podria mantener un registro de todo los logout ademas de
                 * desactivar el token
                 */
            });

            app.post("/new", ctx -> {
                UsuarioInterface nuevo = ctx.bodyAsClass(UsuarioInterface.class);
                UserService userService = new UserService();
                userService.insertOne(nuevo);
            });

            app.put("user={id}", ctx -> {
                UsuarioInterface actualizacion = ctx.bodyAsClass(UsuarioInterface.class);
                UserService userService = new UserService();
                //System.out.println(ctx.pa("id"));;
                userService.updateOne(actualizacion, ctx.pathParam("id"));
            });

            app.delete("/user={id}", ctx -> {
                UserService userService = new UserService();
                // Hay que probar este endpoin
                ctx.json(userService.deleteOne(ctx.attribute("id")));
            });

            app.get("/users", ctx -> {
                UserService userService = new UserService();

                ctx.json(userService.readAll());
            });

            app.get("user={id}", ctx -> {
                UserService userService = new UserService();
                ctx.json(userService.readOne(ctx.pathParam("id")));
            });

           
        });
    }
}
