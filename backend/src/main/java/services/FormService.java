package services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import interfaces.UsuarioInterface;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;

import interfaces.FormFormated;
import interfaces.FormInterface;

public class FormService {

    MongoDatabase db = new BaseService().conexion();

    public FormService() {

    }

    // Insertar Un Formulario
    public InsertOneResult insertOne(@NotNull FormInterface formulario) {
        String foto = null;
        if (formulario.getFoto() != null){
            foto = Base64.getEncoder().encodeToString(formulario.getFoto());
        }
        Document documento = new Document(
                "idUsuario", formulario.getIdUsuario())
                .append("nombre", formulario.getNombre())
                .append("apellido", formulario.getApellido())
                .append("telefono", formulario.getTelefono())
                .append("fecha", formulario.getFecha())
                .append("nivelAcademico", formulario.getNivelAcademico())
                .append("longitud", formulario.getLongitud())
                .append("latitud", formulario.getLatitud())
                .append("foto", foto);

        InsertOneResult resultado = db.getCollection("forms").insertOne(documento);

        return resultado;
    }

    // Update un Form dado su Id
    public void updateOne(@NotNull FormInterface formulario, String idForm) {

        String foto = null;
        if (formulario.getFoto() != null){
            foto = Base64.getEncoder().encodeToString(formulario.getFoto());
        }

        db.getCollection("forms").updateOne(
                Filters.eq("_id", new ObjectId(idForm)),
                new Document("$set", new Document(
                        "_id", new ObjectId(formulario.getIdForm()))
                        .append("idUsuario", formulario.getIdUsuario())
                        .append("nombre", formulario.getNombre())
                        .append("apellido", formulario.getApellido())
                        .append("telefono", formulario.getTelefono())
                        .append("fecha", formulario.getFecha())
                        .append("nivelAcademico", formulario.getNivelAcademico())
                        .append("longitud", formulario.getLongitud())
                        .append("latitud", formulario.getLatitud())
                        .append("foto", foto)));
    }

    // Obtener todos los Formularios
    public FormFormated readAll() {
        List<FormInterface> lista = new ArrayList<FormInterface>();
        MongoCursor<Document> documentos = db.getCollection("forms").find().iterator();
        while (documentos.hasNext()) {
            Document next = documentos.next();
            FormInterface form = new FormInterface();
            form.setIdForm(next.getObjectId("_id").toString());
            form.setIdUsuario(next.getString("idUsuario"));
            form.setNombre(next.getString("nombre"));
            form.setApellido(next.getString("apellido"));
            form.setTelefono(next.getString("telefono"));
            form.setFecha(next.getDate("fecha"));
            form.setNivelAcademico(next.getString("nivelAcademico"));
            form.setLatitud(next.getDouble("latitud"));
            form.setLongitud(next.getDouble("longitud"));
            form.setFoto(null);
            if (next.getString("foto") != null){
                form.setFoto(Base64.getDecoder().decode(next.getString("foto")));
            }
            lista.add(form);
        }
      FormFormated formated = new  FormFormated();
        formated.setForms(lista);
        return formated;
    }

    // Insertar Varios Formularios
    public Object insertMany(List<FormInterface> lista) {
        System.out.println(lista);
        List<Document> documentos = new ArrayList<Document>();
        lista.forEach((formulario) -> {

            System.out.println(formulario.getFoto());
            String foto = null;
            if (formulario.getFoto() != null){
                foto = Base64.getEncoder().encodeToString(formulario.getFoto());
            }

            Document documento = new Document(
                    "idUsuario", formulario.getIdUsuario())
                    .append("nombre", formulario.getNombre())
                    .append("apellido", formulario.getApellido())
                    .append("telefono", formulario.getTelefono())
                    .append("fecha", formulario.getFecha())
                    .append("nivelAcademico", formulario.getNivelAcademico())
                    .append("longitud", formulario.getLongitud())
                    .append("latitud", formulario.getLatitud())
                    .append("foto", foto);
            documentos.add(documento);
        });
        InsertManyResult resultado = db.getCollection("forms")
                .insertMany(documentos);
        return resultado;
    }

    // Obtener Un Solo Form por su Id
    public FormFormated readOneById(String idForm) {
        System.out.println("Id de entrada Form:" + idForm);

        MongoCursor<Document> documentos = db.getCollection("forms").find(
                Filters.eq("idUsuario", idForm)).iterator();
        List<FormInterface> lista = new ArrayList<FormInterface>();
        while (documentos.hasNext()) {
            Document next = documentos.next();

            // Printing Out Json
            System.out.println(next.toJson());

            FormInterface form = new FormInterface();
            form.setIdForm(next.getObjectId("_id").toString());
            form.setIdUsuario(next.getString("idUsuario"));
            form.setNombre(next.getString("nombre"));
            form.setApellido(next.getString("apellido"));
            form.setTelefono(next.getString("telefono"));
            form.setFecha(next.getDate("fecha"));
            form.setNivelAcademico(next.getString("nivelAcademico"));
            form.setLatitud(next.getDouble("latitud"));
            form.setLongitud(next.getDouble("longitud"));
            form.setFoto(null);
            if (next.getString("foto") != null){
                form.setFoto(Base64.getDecoder().decode(next.getString("foto")));
            }
            lista.add(form);
        }
        FormFormated formated = new  FormFormated();
        formated.setForms(lista);
        return formated;
    }


    public Object readOneByName(String name) {
        System.out.println("Id de entrada Form:" + name);

        MongoCursor<Document> documentos = db.getCollection("forms").find(
                Filters.eq("name", name)).iterator();
        List<FormInterface> lista = new ArrayList<FormInterface>();
        while (documentos.hasNext()) {
            Document next = documentos.next();

            // Printing Out Json
            System.out.println(next.toJson());

            FormInterface form = new FormInterface();
            form.setIdForm(next.getObjectId("_id").toString());
            form.setIdUsuario(next.getString("idUsuario"));
            form.setNombre(next.getString("nombre"));
            form.setApellido(next.getString("apellido"));
            form.setTelefono(next.getString("telefono"));
            form.setFecha(next.getDate("fecha"));
            form.setNivelAcademico(next.getString("nivelAcademico"));
            form.setLatitud(next.getDouble("latitud"));
            form.setLongitud(next.getDouble("longitud"));
            form.setFoto(null);
            if (next.getString("foto") != null){
                form.setFoto(Base64.getDecoder().decode(next.getString("foto")));
            }
            lista.add(form);
        }
        Object formated = new Object() {
            public List<FormInterface> forms = lista;
        };
        return formated;
    }

    
}