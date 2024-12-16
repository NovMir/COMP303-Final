package com.FinalTest.Movie;

import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class MongodbConnectionTest {
    
    public void testConnection() {
        // Local MongoDB connection string
        String uri = "mongodb://localhost:27017";
        
        // Configure the server API
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        // Build the connection settings
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("MovieData");
            try {
                // Send a ping to confirm a successful connection
                BsonDocument command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                
                // List all collections in the database
                System.out.println("Available collections:");
                database.listCollectionNames().forEach(System.out::println);
                
            } catch (MongoException me) {
                System.err.println("MongoDB Connection Error: " + me.getMessage());
                me.printStackTrace();
            }
        }
    }
}