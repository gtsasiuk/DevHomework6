package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String sqlFilePath = "sql/populate_db.sql";

        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            String[] queries = sql.split(";");

            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    statement.execute(query.trim());
                }
            }
            System.out.println("Database successfully populated");

        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
