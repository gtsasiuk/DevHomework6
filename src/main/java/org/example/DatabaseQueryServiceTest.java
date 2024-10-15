package org.example;

import org.example.DataSQL.*;

import java.util.List;

public class DatabaseQueryServiceTest {
    public static void main(String[] args) {
        DatabaseQueryService db = new DatabaseQueryService();

        System.out.println("Result of the queries: ");

        List<MaxProjectCountClient> projectCounts = db.findMaxProjectsClient();
        for (MaxProjectCountClient projectCount : projectCounts) {
            System.out.println(projectCount);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

        List<MaxSalaryWorker> workerSalaries = db.findMaxSalaryWorker();
        for (MaxSalaryWorker workerSalary : workerSalaries) {
            System.out.println(workerSalary);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

        List<YoungestEldestWorkers> youngestAndEldestWorkers = db.findYoungestAndEldestWorkers();
        for (YoungestEldestWorkers youngestOrEldestWorker : youngestAndEldestWorkers) {
            System.out.println(youngestOrEldestWorker);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

        List<ProjectPrices> projectPrices = db.printProjectPrices();
        for (ProjectPrices projectPrice : projectPrices) {
            System.out.println(projectPrice);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

        List<LongestProject> longestProjects = db.findLongestProject();
        for (LongestProject longestProject : longestProjects) {
            System.out.println(longestProject);
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
