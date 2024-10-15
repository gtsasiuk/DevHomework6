package org.example.DataSQL;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectPrices {
    private int projectId;
    private double price;

    public ProjectPrices(int projectId, double price) {
        this.projectId = projectId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +  "projectId = " + projectId +  ", price = " + price + '}';
    }
}
