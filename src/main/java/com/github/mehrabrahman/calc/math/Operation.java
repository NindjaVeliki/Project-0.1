package com.github.mehrabrahman.calc.math;

public class Operation {
    public String subcommand;
    public double a;
    public double b;

    public Operation(String subcommand, double a, double b) {
        this.subcommand = subcommand;
        this.a = a;
        this.b = b;
    }

    public Operation() {}
}