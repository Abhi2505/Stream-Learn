package com.leanStream;

public class Employee {
    int id;

    public Employee(int id, String name, Character grade, double salary) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    String name;
    Character grade;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getGrade() {
        return grade;
    }

    public double getSalary() {
        return salary;
    }

    double salary;
}
