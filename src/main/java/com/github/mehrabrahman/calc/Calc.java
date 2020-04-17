package com.github.mehrabrahman.calc;

import com.github.mehrabrahman.calc.math.OperationFactory;
import com.github.mehrabrahman.calc.math.Outputtable;

class Calc {
    public static void main(String[] args) {
        // Parse input: 1) parse subcommand, 2) parse operands  
    	Outputtable operation = OperationFactory.getOperation(args);
    	
        // Output
        System.out.println(operation);
    }
}