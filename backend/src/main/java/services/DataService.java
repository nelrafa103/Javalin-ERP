package services;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import interfaces.LugarInterface;
import interfaces.UsuarioInterface;

public class DataService {
    int Contador_Formularios = 0;
    int Contador_Usuarios = 0;
    int Contador_Peticion = 0;

    /*
     * Esta clase sirve para que el usuario admin pueda ver resumenes de los datos
     * obtenidos,
     * sin ningun problema desde /admin/dashboard en frontend, tengo planeado de que
     * con cada
     * peticion que se haga a la base de datos se aumente el contador de la variable
     * correspondiente
     * O por ejemplo si se implementan graficas en el frontend, se puede implementar
     * aqui la logica
     * Para innovar un poco, podemos implementar un poco de serveless.
     */
    MongoDatabase db = new BaseService().conexion();

    public Object addPlace(String place, double latitud, double longitud) {
        Document nuevo = new Document("lugar", place).append("fecha", LocalDateTime.now()).append("longitud", longitud)
                .append("latitud", latitud);
        InsertOneResult resultado = db.getCollection("lugares").insertOne(nuevo);

        return resultado;

    }

    public Object getAllUsers() {
        // Hay que hace un contador que mantenga una referencia en la base de datos
        return db.getCollection("users").countDocuments();
    }

    public Object getAllForms() {
        return db.getCollection("forms").countDocuments();

    }

    public Object getAllPlaces() {
        List<LugarInterface> lugares = new ArrayList<LugarInterface>();
        MongoCursor<Document> documentos = db.getCollection("lugares").find().limit(10).iterator();
        while (documentos.hasNext()) {
            Document documento = documentos.next();
            LugarInterface lugar = new LugarInterface();
            lugar.setFecha(documento.getDate("fecha"));
            lugar.setLugar(documento.getString("lugar"));
            lugar.setLatitud(documento.getDouble("latitud"));
            lugar.setLongitud(documento.getDouble("longitud"));

            lugares.add(lugar);
        }

        return lugares;
    }

    public Object getCountPlaces() {
        return db.getCollection("lugares").countDocuments();
    }

    public void calcularPropocionalidad() {

        // Talvez aqui va algo de codigo para que los usuarios puedan ver la
        // proporcionalidad de los datos segun
        // la region donde se toma el formulario. Si utilzamos google functions seria
        // bien facil. pues hay sdk para java
        // solo habria que hacer una peticion a una funcion pre-creada en la plataforma
        // de google y mandarle los datos
        // Y tomar los datos y luego devolverla al usuario en el frontend
    }
}
