package src;

import java.sql.SQLException;
import java.util.Date;

import src.Models.User;
import src.Services.QueryBuilderService;

public class Main {

    public static void main(String[] args) {

        // User user1 = new User(1, "Jesse Dan", "jessedan160", "jessedan@qtella.com", "1234567890", "123 Main St", new Date(),
        //         new Date(), new Date());
        // User user2 = new User(2, "Alice Smith", "alice_smith89", "alice@example.com", "9876543210", "456 Oak St",
        //         new Date(), new Date(), new Date());
        // User user3 = new User(3, "Bob Johnson", "bob_j", "bob@example.com", "5551112222", "789 Elm St", new Date(),
        //         new Date(), new Date());
        // User user4 = new User(4, "Emma Brown", "emma_brown77", "emma@example.com", "4443332222", "890 Pine St",
        //         new Date(), new Date(), new Date());
        // User user5 = new User(5, "Michael Davis", "mike_d", "michael@example.com", "9998887777", "567 Cedar St",
        //         new Date(), new Date(), new Date());

        //     user1.saveUser();
       
 new QueryBuilderService()
                .createTable("users")
                .column("id").column("INT(10)").notNull().primary().autoIncrement().comma()
                .column("full_name").varchar(200).notNull().comma()
                .column("username").varchar(50).notNull().comma()
                .column("email").varchar(100).notNull().comma()
                .column("phone_number").varchar(20).comma()
                .column("address").varchar(255).comma()
                .column("date_of_birth").column("DATE").notNull().comma()
                .column("created_at").column("TIMESTAMP").defaultVal("CURRENT_TIMESTAMP").comma()
                .column("updated_at").column("TIMESTAMP").defaultVal("CURRENT_TIMESTAMP").onUpdateCurrentTimestamp().close()
                .build();

    }
}