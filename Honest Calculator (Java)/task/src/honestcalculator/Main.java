package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String numRegex = "(\\d+.\\d+|\\d+)";

        while (true) {
            System.out.println("Enter an equation");
            String[] equation = sc.nextLine().trim().split(" ");
            boolean isXValid = equation[0].matches(numRegex);
            boolean isYValid = equation[2].matches(numRegex);

            if (!isXValid || !isYValid) {
                System.out.println("Do you even know what numbers are? Stay focused!");
                continue;
            }

            String operator = equation[1];
            if (!operator.equals("+") &&
                    !operator.equals("-") &&
                    !operator.equals("*") &&
                    !operator.equals("/")) {
                System.out.println("Yes ... an interesting math operation. You've slept through all classes, haven't you?");
                continue;
            }


            float x = Float.parseFloat(equation[0]);
            float y = Float.parseFloat(equation[2]);

            if (operator.equals("/") && y == 0) {
                System.out.println("Yeah... division by zero. Smart move...");
                continue;
            }

            float result = switch (operator) {
                case "+" -> x + y;
                case "-" -> x - y;
                case "*" -> x * y;
                case "/" -> x / y;
                default -> 0;
            };

            System.out.println(result);
            break;
        }
    }
}
