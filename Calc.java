import java.util.Scanner;

class Calc {
    public static void main(String[] args) {
        /* int a = Integer.parseInt(args[0]);
        String operator = args[1];
        int b = Integer.parseInt(args[2]);

        if (operator.equals("+")) {
            System.out.println(a + b);
        }*/
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int a = input.nextInt();

        System.out.print("Enter an operator: ");
        String op = input.next();

        System.out.print("Enter an integer: ");
        int b = input.nextInt();

        switch(op) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
            default:
                System.out.println("Please input a valid arithmetic operator");
        }
    }
}