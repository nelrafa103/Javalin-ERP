package controllers.grpc;

import controllers.BaseController;
import io.javalin.Javalin;

public class FormController extends BaseController {

    public FormController(Javalin app) {
        super(app);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void routas() {
        app.routes(() -> {
    

        });
    }
    
}

/*FormRmGrpc.FormRmBlockingStub formInterfaz = FormRmGrpc.newBlockingStub(channel);
        UsuarioRnGrpc.UsuarioRnBlockingStub usuarioInterfaz = UsuarioRnGrpc.newBlockingStub(channel); */
