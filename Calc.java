class Calc {
    public static void main(String[] args) {
        // Parse input: 1) parse subcommand, 2) parse operands
        String subcommand = "";
        double a = 0.0;
        double b = 0.0;
        if (args.length > 0) {
            subcommand = args[0];
            try {
                a = Double.parseDouble(args[1]);
                b = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                System.exit(1);
            }
        }

        // Select operation
        double output = 0.0;
        if (subcommand.equals("add")) {
            // Perform operation
            output = a + b;
        }

        if (subcommand.equals("sub")) {
            output = a - b;
        }

        if (subcommand.equals("mul")) {
            output = a * b;
        }

        if (subcommand.equals("div")) {
            output = a / b;
        }

        // Output
        System.out.println(output);
    }
}