package org.example;

import org.example.DataSQL.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private String readingSqlFile(String filePath) throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get(filePath)));
        return sql;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> projectCounts = new ArrayList<>();
        String sqlFilePath = "sql/find_max_projects_client.sql";

        try {
            String sql = readingSqlFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String name = rs.getString("name");
                    int projectCount = rs.getInt("project_count");
                    projectCounts.add(new MaxProjectCountClient(name, projectCount));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return projectCounts;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> workerSalaries = new ArrayList<>();
        String sqlFilePath = "sql/find_max_salary_worker.sql";

        try {
            String sql = readingSqlFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");
                    workerSalaries.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return workerSalaries;
    }

    public List<YoungestEldestWorkers> findYoungestAndEldestWorkers() {
        List<YoungestEldestWorkers> youngestAndEldestWorkers = new ArrayList<>();
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";

        try {
            String sql = readingSqlFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
                    youngestAndEldestWorkers.add(new YoungestEldestWorkers(type, name, birthday));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return youngestAndEldestWorkers;
    }

    public List<ProjectPrices> printProjectPrices() {
        List<ProjectPrices> projectPrices = new ArrayList<>();
        String sqlFilePath = "sql/print_project_prices.sql";

        try {
            String sql = readingSqlFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    int projectId = rs.getInt("id");
                    double price = rs.getDouble("price");
                    projectPrices.add(new ProjectPrices(projectId, price));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return projectPrices;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjects = new ArrayList<>();
        String sqlFilePath = "sql/find_longest_project.sql";

        try {
            String sql = readingSqlFile(sqlFilePath);

            try (Connection connection = Database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    int projectId = rs.getInt("id");
                    int monthCount = rs.getInt("month_count");
                    longestProjects.add(new LongestProject(projectId, monthCount));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }

        return longestProjects;
    }
}
