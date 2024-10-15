package org.example.DataSQL;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LongestProject {
    private int projectId;
    private int monthCount;

    public LongestProject(int projectId, int monthCount) {
        this.projectId = projectId;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" + "projectId = " + projectId + ", monthCount = " + monthCount + '}';
    }
}
