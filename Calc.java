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

        Operation() {
        }
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

    public void calculate(Operation operation) {
        double output = 0.0;

        switch (operation.subcommand) {
            case "+":
                output = operation.a + operation.b;
                break;
            case "-":
                output = operation.a - operation.b;
                break;
            case "*":
                output = operation.a * operation.b;
                break;
            case "/":
                output = operation.a / operation.b;
                break;
            case "%":
                output = operation.a % operation.b;
                break;
            default:
                System.out.println("Unrecognized");
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        // Parse input: 1) parse subcommand, 2) parse operands
        System.out.println("Please enter 1st operand:");
        String a = System.console().readLine();

        System.out.println("Please enter operator");
        String op = System.console().readLine();

        System.out.println("Please enter 2nd operand:");
        String b = System.console().readLine();

        String[] inputs = {op, a, b};

        Calc calc = new Calc();
        Operation operation = calc.parse(inputs);
        calc.calculate(operation);
    }
}