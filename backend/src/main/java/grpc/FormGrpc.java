package grpc;

import com.google.protobuf.ByteString;
import data.Data;
import data.FormRmGrpc;
import io.grpc.stub.StreamObserver;
import services.FormService;
import interfaces.FormFormated;
import interfaces.FormInterface;

import java.util.ArrayList;
import java.util.List;


public class FormGrpc extends FormRmGrpc.FormRmImplBase {

    private FormService formService = new FormService();


    // Obtener el Form por Id
    @Override
    public void getForm(Data.FormRequest request, StreamObserver<Data.FormInterface> responseObserver) {
        FormFormated form =  formService.readOneById(request.getValueStr());
        if (form.getForms().size() == 0){
            responseObserver.onError(new Exception("No se encontro el form " + request.getValueStr()));
        }
        responseObserver.onNext(convertir(form.getForms().get(0)));
        responseObserver.onCompleted();
    }

    @Override
    public void insertForm(Data.FormInterface request, StreamObserver<Data.FormInterface> responseObserver) {
        formService.insertOne(convertir(request));
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

    @Override
    public void updateForm(Data.FormInterface request, StreamObserver<Data.FormInterface> responseObserver) {
        formService.updateOne(convertir(request), request.getIdForm());
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteForm(Data.FormRequest request, StreamObserver<Data.FormDelete> responseObserver) {
        responseObserver.onNext(Data.FormDelete.newBuilder().setOk(false).build());
        responseObserver.onCompleted();
    }

    @Override
    public void listForm(Data.Empty request, StreamObserver<Data.ListaForm> responseObserver) {
        FormFormated forms =  formService.readAll();
         
        List<Data.FormInterface> formLista = new ArrayList<>();
        for (FormInterface e : forms.getForms()){
            formLista.add(convertir(e));
        }
        Data.ListaForm build = Data.ListaForm.newBuilder().addAllForm(formLista).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    @Override
    public void listFormUsuarioId(Data.FormRequest request, StreamObserver<Data.ListaForm> responseObserver) {
        FormFormated forms =  formService.readAll();
        List<Data.FormInterface> formLista = new ArrayList<>();
        for (FormInterface e : forms.getForms()){
            if (e.getIdUsuario().equals(request.getValueStr())){
                formLista.add(convertir(e));
            }
        }
        Data.ListaForm build = Data.ListaForm.newBuilder().addAllForm(formLista).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    @Override
    public void listFormNombre(Data.FormRequest request, StreamObserver<Data.ListaForm> responseObserver) {
        FormFormated forms = formService.readAll();
        List<Data.FormInterface> formLista = new ArrayList<>();
        for (FormInterface e : forms.getForms()){
            if (e.getNombre().equals(request.getValueStr())){
                formLista.add(convertir(e));
            }
        }
        Data.ListaForm build = Data.ListaForm.newBuilder().addAllForm(formLista).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    /**
     * Convierte la clase del modelo para enviar por el servicio gRPC.
     * @param form
     * @return
     */
    private Data.FormInterface convertir(FormInterface form){
        if (form.getFoto() != null){
            return Data.FormInterface.newBuilder()
                    .setIdForm(form.getIdForm())
                    .setIdUsuario(form.getIdUsuario())
                    .setNombre(form.getNombre())
                    .setApellido(form.getApellido())
                    .setTelefono(form.getTelefono())
                    .setNivelAcademico(form.getNivelAcademico())
                    .setLatitud(form.getLatitud())
                    .setLongitud(form.getLongitud())
                    .setFoto(ByteString.copyFrom(form.getFoto()))
                    .build();
        }
        return Data.FormInterface.newBuilder()
                .setIdForm(form.getIdForm())
                .setIdUsuario(form.getIdUsuario())
                .setNombre(form.getNombre())
                .setApellido(form.getApellido())
                .setTelefono(form.getTelefono())
                .setNivelAcademico(form.getNivelAcademico())
                .setLatitud(form.getLatitud())
                .setLongitud(form.getLongitud())
                .build();

    }
    /**
     *
     * @param e
     * @return
     */
    private FormInterface convertir(Data.FormInterface e){
        FormInterface f = new FormInterface();
            f.setIdUsuario(e.getIdUsuario());
            f.setIdForm(e.getIdForm());
            f.setNombre(e.getNombre());
            f.setApellido(e.getApellido());
            f.setTelefono(e.getTelefono());
            f.setFecha(null);
            f.setNivelAcademico(e.getNivelAcademico());
            f.setLatitud(e.getLatitud());
            f.setLongitud(e.getLongitud());
            f.setFoto(null);
            if (e.getFoto() != null){
                f.setFoto(e.getFoto().toByteArray());
            }
        return f;
    }

}
