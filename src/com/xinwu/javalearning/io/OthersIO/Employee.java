package com.xinwu.javalearning.io.OthersIO;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private Integer salary;
    private transient String unneccesary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getUnneccesary() {
        return unneccesary;
    }

    public void setUnneccesary(String unneccesary) {
        this.unneccesary = unneccesary;
    }

    @Override
    public String toString() {
        return String.format("name: %s, and salary: %s; last the unneccesary info: %s", name, salary, unneccesary);
    }
}
