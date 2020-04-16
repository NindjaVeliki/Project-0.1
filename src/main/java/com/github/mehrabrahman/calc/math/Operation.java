package com.github.mehrabrahman.calc.math;

/**
This class holds data for an operation.
@author Mehrab
@version 0.1.0
*/
public class Operation {
    private String subcommand;
    private double a;
    private double b;
    private double output;

    public Operation(String[] args) {
        if (args.length > 0) {
            this.subcommand = args[0];
            try {
                this.a = Double.parseDouble(args[1]);
                this.b = Double.parseDouble(args[2]);
                this.output = this.output();
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                System.exit(1);
            }
        }
    }

    private double output() {
        switch (subcommand) {
            case "add":
                return this.a + this.b;
            case "sub":
                return this.a - this.b;
            case "mul":
                return this.a * this.b;
            case "div":
                return this.a / this.b;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return this.a + " + " + this.b + " = " + this.output;
    }
}