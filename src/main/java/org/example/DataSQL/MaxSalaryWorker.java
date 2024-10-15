package org.example.DataSQL;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaxSalaryWorker {
    private String name;
    private int salary;

    public MaxSalaryWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" + "Worker's name = " + name + ", its salary = " + salary + " UAH}";
    }
}
