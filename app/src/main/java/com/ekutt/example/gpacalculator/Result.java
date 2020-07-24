package com.ekutt.example.gpacalculator;

public class Result {
    private float gpa;
    private int totalCredits;
    private String name;

    public Result(String name, int totalCredits, float gpa) {
        this.totalCredits = totalCredits;
        this.gpa = gpa;
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }
}
