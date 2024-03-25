package grpc;

import com.google.protobuf.ByteString;
import data.Data;
import data.UsuarioRnGrpc;
import interfaces.UsuarioFormated;
import interfaces.UsuarioInterface;
import io.grpc.stub.StreamObserver;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UsuarioGrpc extends UsuarioRnGrpc.UsuarioRnImplBase {

    private UserService userService = new UserService();

    @Override
    public void getUsuario(Data.UsuarioRequest request, StreamObserver<Data.UsuarioInteface> responseObserver) {
        UsuarioInterface user = (UsuarioInterface) userService.readOne(request.getUsuarioId());
        if (user != null){
            responseObserver.onNext(convertir(user));
            responseObserver.onCompleted();
        }else{
            responseObserver.onError(new Exception("No se encontro el user " + request.getUsuarioId()));
        }

    }

    @Override
    public void getUsuarioLogin(Data.UsuarioLogin request, StreamObserver<Data.UsuarioInteface> responseObserver) {
        UsuarioInterface user = (UsuarioInterface) userService.login(request.getCorreo(), request.getContrasena());
        if (user != null){
            responseObserver.onNext(convertir(user));
            responseObserver.onCompleted();
        }else{
            responseObserver.onError(new Exception("Revisar correo y contraseña de usuario, no se pudo obtener el usuario"));
        }
    }

    @Override
    public void insertUsuario(Data.UsuarioInteface request, StreamObserver<Data.UsuarioInteface> responseObserver) {
        userService.insertOne(convertir(request));
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUsuario(Data.UsuarioInteface request, StreamObserver<Data.UsuarioInteface> responseObserver) {
        userService.updateOne(convertir(request), request.getIdUsuario());
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUsuario(Data.UsuarioRequest request, StreamObserver<Data.UsuarioDelete> responseObserver) {
        userService.deleteOne(request.getUsuarioId());
        responseObserver.onNext(Data.UsuarioDelete.newBuilder().setOk(true).build());
        responseObserver.onCompleted();
    }

    @Override
    public void listUsuario(Data.Empty request, StreamObserver<Data.ListaUsuario> responseObserver) {
        UsuarioFormated users = userService.readAll();
        List<Data.UsuarioInteface> userLista = new ArrayList<>();
        for (UsuarioInterface u : users.getUsuarios()){
            userLista.add(convertir(u));
        }
        Data.ListaUsuario build = Data.ListaUsuario.newBuilder().addAllUsuario(userLista).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    /**
     * Convierte la clase del modelo para enviar por el servicio gRPC.
     * @param user
     * @return
     */
    private Data.UsuarioInteface convertir(UsuarioInterface user){
        if (user.getFoto() != null){
            return Data.UsuarioInteface.newBuilder()
                    .setIdUsuario(user.getIdUsuario())
                    .setNombre(user.getNombre())
                    .setApellido(user.getApellido())
                    .setCedula(user.getCedula())
                    .setContrasena(user.getContrasena())
                    .setDireccion(user.getDireccion())
                    .setCorreo(user.getCorreo())
                    .setActivo(user.isActivo())
                    .setFoto(ByteString.copyFrom(user.getFoto()))
                    .setIdRole(user.getIdRole())
                    .build();
        }

        return Data.UsuarioInteface.newBuilder()
                .setIdUsuario(user.getIdUsuario())
                .setNombre(user.getNombre())
                .setApellido(user.getApellido())
                .setCedula(user.getCedula())
                .setContrasena(user.getContrasena())
                .setDireccion(user.getDireccion())
                .setCorreo(user.getCorreo())
                .setActivo(user.isActivo())
                .setIdRole(user.getIdRole())
                .build();
    }
    /**
     *
     * @param e
     * @return
     */
    private UsuarioInterface convertir(Data.UsuarioInteface e){
        UsuarioInterface u = new UsuarioInterface();
        u.setIdUsuario(e.getIdUsuario());
        u.setNombre(e.getNombre());
        u.setApellido(e.getApellido());
        u.setCedula(e.getCedula());
        u.setContrasena(e.getContrasena());
        u.setDireccion(e.getDireccion());
        u.setCorreo(e.getCorreo());
        u.setActivo(e.getActivo());
        u.setFechaNacimiento(null);
        u.setFoto(null);
        if (e.getFoto() != null){
            u.setFoto(e.getFoto().toByteArray());
        }
        u.setIdRole(e.getIdRole());
        return u;
    }
}
