package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String numRegex = "[+-]?\\d+(.\\d+)?";

        float memory = 0;

        boolean isProgramOn = true;
        while (isProgramOn) {
            System.out.println("Enter an equation");
            String[] equation = sc.nextLine().trim().split(" ");
            String strX = equation[0];
            String strY = equation[2];
            float x, y;

            if (strX.equals("M")) {
                x = memory;
            } else {
                x = Float.parseFloat(strX);
            }

            if (strY.equals("M")) {
                y = memory;
            } else {
                y = Float.parseFloat(strY);
            }

            boolean isXValid = String.valueOf(x).matches(numRegex);
            boolean isYValid = String.valueOf(y).matches(numRegex);

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

            while (true) {
                System.out.println("Do you want to store the result? (y / n):");
                String isResultStored = sc.nextLine().trim();
                if (isResultStored.equals("y")) {
                    memory = result;
                    break;
                } else if (isResultStored.equals("n")) {
                    break;
                }
            }

            while (true) {
                System.out.println("Do you want to continue calculations? (y / n):");
                String continueCalculations = sc.nextLine().trim();
                if (continueCalculations.equals("y")) {
                    break;
                } else if (continueCalculations.equals("n")) {
                    isProgramOn = false;
                    break;
                }
            }
        }
    }
}
