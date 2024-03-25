package services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import com.mongodb.client.model.BsonField;
import interfaces.UsuarioFormated;
import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Filters.*;

import interfaces.UsuarioInterface;

import static com.mongodb.client.model.Filters.eq;

public class UserService {
    MongoDatabase db = new BaseService().conexion();

    public UserService() {

    }

    // Obtener el usuario dado un correo y contrasena
    public UsuarioInterface login(String correo, String contrasena) {
        Document doc = db.getCollection("users")
                .find(Filters.and(eq("correo", correo), eq("contrasena", contrasena))).first();

        // Si no se encontro nada
    
        // Si se encontro el usuario
        UsuarioInterface usuario = new UsuarioInterface();
        usuario.setIdUsuario(doc.getObjectId("_id").toString());
        usuario.setNombre(doc.getString("nombre"));
        usuario.setApellido(doc.getString("apellido"));
        usuario.setCedula(doc.getString("cedula"));
        usuario.setContrasena(doc.getString("contrasena"));
        usuario.setDireccion(doc.getString("direccion"));
        usuario.setCorreo(doc.getString("correo"));
        usuario.setActivo(doc.getBoolean("activo"));
        usuario.setFechaNacimiento(doc.getDate("fechaNacimiento"));
        usuario.setFoto(null);
        if (doc.getString("foto") != null){
            usuario.setFoto(Base64.getDecoder().decode(doc.getString("foto")));
        }
        usuario.setIdRole(doc.getInteger("idRole"));

        return usuario;
    }

    // TODO: Logout (no se si es necesario)
    public boolean logout() {
        return false;
    }

    // Insertar un Usuario
    public boolean insertOne(@NotNull UsuarioInterface usuario) {
        String foto = null;
        if (usuario.getFoto() != null){
            foto = Base64.getEncoder().encodeToString(usuario.getFoto());
        }
        Document documento = new Document(
                "nombre", usuario.getNombre())
                .append("apellido", usuario.getApellido())
                .append("cedula", usuario.getCedula())
                .append("contrasena", usuario.getContrasena())
                .append("direccion", usuario.getDireccion())
                .append("correo", usuario.getCorreo())
                .append("activo", usuario.isActivo())
                .append("fechaNacimiento", usuario.getFechaNacimiento())
                .append("foto", foto)
                .append("idRole", usuario.getIdRole());

        db.getCollection("users").insertOne(documento);

        return true;
    }

    // Update Un Usuario dado su Id
    public void updateOne(@NotNull UsuarioInterface usuario, String idUsuario) {

        String foto = null;
        if (usuario.getFoto() != null){
            foto = Base64.getEncoder().encodeToString(usuario.getFoto());
        }

        db.getCollection("users").updateOne(
                eq("_id", new ObjectId(idUsuario)),
                new Document("$set", new Document(
                        "_id", new ObjectId(idUsuario))
                        .append("nombre", usuario.getNombre())
                        .append("apellido", usuario.getApellido())
                        .append("cedula", usuario.getCedula())
                        .append("contrasena", usuario.getContrasena())
                        .append("direccion", usuario.getDireccion())
                        .append("correo", usuario.getCorreo())
                        .append("activo", usuario.isActivo())
                        .append("fechaNacimiento", usuario.getFechaNacimiento())
                        .append("foto", foto)
                        .append("idRole", usuario.getIdRole())));
    }

    // Borrar un Usuario, cambiando su activo a False
    // TODO: Arreglar esto, no se puede borrar un usuario, sino que hay que poner su activo en False.
    public Object deleteOne(String id) {
        return db.getCollection("users").deleteOne(Filters.eq("idUsuario", id));
    }


    // Obtener todos los Usuarios
    // TODO: Remover el limite
    public UsuarioFormated readAll() {

        /*
         * Comente la parte de las imagenes por ahora, para que sea mas facil probar
         */
        List<UsuarioInterface> usuarios = new ArrayList<UsuarioInterface>();
        MongoCursor<Document> documentos = db.getCollection("users").find().limit(10).iterator();
        while (documentos.hasNext()) {
            Document next = documentos.next();
            UsuarioInterface usuario = new UsuarioInterface();
            usuario.setIdUsuario(next.getObjectId("_id").toString());
            usuario.setNombre(next.getString("nombre"));
            usuario.setApellido(next.getString("apellido"));
            usuario.setCedula(next.getString("cedula"));
            usuario.setContrasena(next.getString("contrasena"));
            usuario.setDireccion(next.getString("direccion"));
            usuario.setCorreo(next.getString("correo"));
            usuario.setActivo(next.getBoolean("activo"));
            usuario.setFechaNacimiento(next.getDate("fechaNacimiento"));
            usuario.setFoto(null);
            if (next.getString("foto") != null){
                usuario.setFoto(Base64.getDecoder().decode(next.getString("foto")));
            }
            usuario.setIdRole(next.getInteger("idRole"));
            usuarios.add(usuario);
           // System.out.println(documentos.next().toJson());
        }
        UsuarioFormated formated = new UsuarioFormated();
        formated.setUsuarios(usuarios);
        return formated;
    }

    // Obtener un Usuario dado su id
    public Object readOne(String idUsuario) {

        Document doc = db.getCollection("users").find(
                eq("_id", new ObjectId(idUsuario))).first();

        // Si no se encontro nada
        if (doc == null){
            return null;
        }

        // Si se encontro el usuario
        UsuarioInterface usuario = new UsuarioInterface();
        usuario.setIdUsuario(doc.getObjectId("_id").toString());
        usuario.setNombre(doc.getString("nombre"));
        usuario.setApellido(doc.getString("apellido"));
        usuario.setCedula(doc.getString("cedula"));
        usuario.setContrasena(doc.getString("contrasena"));
        usuario.setDireccion(doc.getString("direccion"));
        usuario.setCorreo(doc.getString("correo"));
        usuario.setActivo(doc.getBoolean("activo"));
        usuario.setFechaNacimiento(doc.getDate("fechaNacimiento"));
        usuario.setFoto(null);
        if (doc.getString("foto") != null){
            usuario.setFoto(Base64.getDecoder().decode(doc.getString("foto")));
        }
        usuario.setIdRole(doc.getInteger("idRole"));

        return usuario;
    }

}