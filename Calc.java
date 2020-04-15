class Calc {
    class Operation {
        String subcommand;
        double a;
        double b;

        Operation(String subcommand, double a, double b) {
            this.subcommand = subcommand;
            this.a = a;
            this.b = b;
        }

        Operation() {}

        double add(){
            double result = 0.0;
            result = this.a + this.b;
            return result;
        }

        double sub(){
            double result = 0.0;
            result = this.a - this.b;
            return result;
        }

        double mul(){
            double result = 0.0;
            result = this.a * this.b;
            return result;
        }

        double div(){
            double result = 0.0;
            result = this.a / this.b;
            return result;
        }


    }

    public double selectOperation(Operation operation){
        double output = 0.0;
        if (operation.subcommand.equals("add")) {
            // Perform operation
            output = operation.add();
        } else if (operation.subcommand.equals("sub")) {
            output = operation.sub();
        } else if (operation.subcommand.equals("mul")) {
            output = operation.mul();
        } else if (operation.subcommand.equals("div")) {
            output = operation.div();
        } else {
            System.out.println("Unrecognized");
        }
        return output;
    }
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
        double output = 0.0;

        // Select operation
        output = calc.selectOperation(operation);

        // Output
        System.out.println(output);
    }
}