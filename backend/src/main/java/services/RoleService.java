package services;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import interfaces.RolesInterface;
import interfaces.UsuarioInterface;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoleService {
    MongoDatabase db = new BaseService().conexion();

    public RoleService() {

    }

    // Insertar un Role
    public boolean insertOne(@NotNull RolesInterface role) {
        Document documento = new Document(
                "idRole", role.getIdRole())
                .append("nombre", role.getNombre());

        db.getCollection("roles").insertOne(documento);

        return true;
    }

    // Update Un Role dado su Id
    public void updateOne(@NotNull RolesInterface role) {
        db.getCollection("roles").updateOne(Filters.eq("idRole", role.getIdRole()),
                new Document("$set", new Document(
                        "idRole", role.getIdRole())
                        .append("nombre", role.getNombre())));
    }

    // Borrar un Usuario, cambiando su activo a False
    // TODO: Arreglar esto, no se puede borrar un usuario, sino que hay que poner su activo en False.
    public void deleteOne(String id) {
        db.getCollection("roles").deleteOne(Filters.eq("idRoles", id));
    }


    // Obtener todos los Roles
    // TODO: Remover el limite
    public Object readAll() {

        List<RolesInterface> roles = new ArrayList<RolesInterface>();
        MongoCursor<Document> documentos = db.getCollection("roles").find().limit(10).iterator();
        while (documentos.hasNext()) {
            Document next = documentos.next();
            RolesInterface role = new RolesInterface();
            role.setIdRole(next.getInteger("idRole"));
            role.setNombre(next.getString("nombre"));
            roles.add(role);
           // System.out.println(documentos.next().toJson());
        }
        Object formated = new Object() {
            public List<RolesInterface> roless = roles;
        };
        return formated;
    }

    // Obtener un Role dado su id
    public Object readOne(Integer idRole) {

        Document doc = db.getCollection("roles")
                .find(Filters.eq("idRole", idRole)).first();

        // Si no se encontro nada
        if (doc == null){
            return null;
        }

        // Si se encontro el usuario
        RolesInterface role = new RolesInterface();
        role.setIdRole(doc.getInteger("idRole"));
        role.setNombre(doc.getString("nombre"));

        return role;
    }

}