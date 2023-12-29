package src;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.Services.QueryBuilderService;

public class Main {

    public static void main(String[] args) {
        QueryBuilderService qbs = new QueryBuilderService();
        ResultSet queryResult = qbs
                .select()
                .all()
                .from()
                .table("USERS")
                .where("")
                // .timestamp("created_at", ">", "2023-01-01 00:00:00")
                .contains("full_name", "John Doe")
                .runQuery();

        System.out.println("QUERY: " + qbs.build());

        try {
            while (queryResult.next() && queryResult != null) {
                String fullName = queryResult.getString("address");
                System.out.println("Full Name: " + fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}