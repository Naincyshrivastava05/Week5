package com.ioprogramming.advanceprogramming.CSVDataintoJavaObjects;

public class Students{
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Students(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "Student{ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + "}";
    }
}

