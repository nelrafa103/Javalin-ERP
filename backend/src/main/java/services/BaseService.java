package services;

import org.bson.BsonDocument;
import org.bson.Document;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class BaseService {

    public MongoClient cliente;

    public BaseService() {

        // db.getCollection("users").insertOne(new Document("name", "Nelcido"));

        // TODO Auto-generated constructor stub
    }

    public MongoDatabase conexion() {
        cliente = MongoClients.create(
                "mongodb+srv://client1:wfHcfsX5ln7Rjxal@pucmm-paths.ynfh0ia.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = cliente.getDatabase("proyecto");

        return db;
    }

}
