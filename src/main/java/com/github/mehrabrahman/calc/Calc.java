package com.github.mehrabrahman.calc;

import com.github.mehrabrahman.calc.math.Operation;

class Calc {
    public Operation parse(String[] args) {
        Operation operation = new Operation();
        String subcommand = "";
        double a = 0.0;
        double b = 0.0;
        if (args.length > 0) {
            subcommand = args[0];
            try {
                a = Double.parseDouble(args[1]);
                b = Double.parseDouble(args[2]);
                operation = new Operation(subcommand, a, b);
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                System.exit(1);
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        // Parse input: 1) parse subcommand, 2) parse operands        
        Calc calc = new Calc();
        Operation operation = calc.parse(args);

        // Select operation
        double output = 0.0;
        if (operation.subcommand.equals("add")) {
            // Perform operation
            output = operation.a + operation.b;
        } else if (operation.subcommand.equals("sub")) {
            output = operation.a - operation.b;
        } else if (operation.subcommand.equals("mul")) {
            output = operation.a * operation.b;
        } else if (operation.subcommand.equals("div")) {
            output = operation.a / operation.b;
        } else {
            System.out.println("Unrecognized");
        }

        // Output
        System.out.println(output);
    }
}