package org.example;

import java.time.LocalDate;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private LocalDate birthday;

    public YoungestEldestWorkers(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" + "Type = " + type + ", Worker's name = " + name + ", its birthday=" + birthday + '}';
    }
}
