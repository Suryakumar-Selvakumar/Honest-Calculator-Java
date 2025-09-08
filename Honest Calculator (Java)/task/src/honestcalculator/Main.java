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

            check(x, y, operator);

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

            System.out.printf("%.1f\n", result);

            while (true) {
                System.out.println("Do you want to store the result? (y / n):"); // msg_4
                String isResultStored = sc.nextLine().trim();
                if (isResultStored.equals("y")) {
                    if (is_one_digit(result)) {
                        int msg_index = 10;
                        while (true) {
                            System.out.println(msg_index == 10 ?
                                    "Are you sure? It is only one digit! (y / n)" : // msg_10
                                    msg_index == 11 ?
                                            "Don't be silly! It's just one number! Add to the memory? (y / n)" : // msg_11
                                            "Last chance! Do you really want to embarrass yourself? (y / n)"); // msg_12
                            isResultStored = sc.nextLine().trim();
                            if (isResultStored.equals("y")) {
                                if (msg_index < 12) {
                                    msg_index++;
                                } else {
                                    memory = result;
                                    break;
                                }
                            } else if (isResultStored.equals("n")) {
                                break;
                            }
                        }
                    } else {
                        memory = result;
                    }
                    break;
                } else if (isResultStored.equals("n")) {
                    break;
                }
            }

            while (true) {
                System.out.println("Do you want to continue calculations? (y / n):"); // msg_5
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

    static void check(float v1, float v2, String v3) {
        StringBuilder msg = new StringBuilder();

        if (is_one_digit(v1) && is_one_digit(v2)) {
            msg.append(" ... lazy"); // msg_6
        }

        if ((v1 == 1 || v2 == 1) && v3.equals("*")) {
            msg.append(" ... very lazy"); // msg_7
        }

        if ((v1 == 0 || v2 == 0) && (v3.equals("*") || v3.equals("+") || v3.equals("-"))) {
            msg.append(" ... very, very lazy"); // msg_8
        }

        if (!msg.isEmpty()) {
            msg.insert(0, "You are");
            System.out.println(msg);
        }
    }

    static boolean is_one_digit(float v) {
        return v > -10 && v < 10 && String.valueOf(v).matches("\\d+\\.0");
    }
}
