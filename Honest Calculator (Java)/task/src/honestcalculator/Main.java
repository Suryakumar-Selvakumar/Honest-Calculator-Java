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
            boolean num1 = equation[0].matches(numRegex);
            boolean num2 = equation[2].matches(numRegex);

            if (!num1 || !num2) {
                System.out.println("Do you even know what numbers are? Stay focused!");
                continue;
            }

            String operator = equation[1];
            if (operator.equals("+") ||
                    operator.equals("-") ||
                    operator.equals("*") ||
                    operator.equals("/")) {
                break;
            } else {
                System.out.println("Yes ... an interesting math operation. You've slept through all classes, haven't you?");
            }
        }
    }
}
