package com.ekutt.example.gpacalculator;

public class Result {
    float gpa;
    int totalCredits;
    String name;

    public Result(String name, int totalCredits, float gpa) {
        this.totalCredits = totalCredits;
        this.gpa = gpa;
        this.name = name;
    }
}
