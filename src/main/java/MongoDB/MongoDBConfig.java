package MongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


    @Configuration
    public class MongoDBConfig {

        @Bean
        public MongoClient mongoClient() {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://clikball:Deif9312@cluster0.hqibc19.mongodb.net/?retryWrites=true&w=majority");
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    //.sslEnabled(true)
                    .build();

            return MongoClients.create(mongoClientSettings);
        }
    }

