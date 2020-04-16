package com.github.mehrabrahman.calc;

import com.github.mehrabrahman.calc.math.Operation;

class Calc {
    public static void main(String[] args) {
        // Parse input: 1) parse subcommand, 2) parse operands  
        Operation operation = new Operation(args);
        // Output
        System.out.println(operation);
    }
}