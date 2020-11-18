package com.natali;

import java.util.Scanner;
import java.util.Stack;

public class StackSolution {

    private static boolean isValidExpression(String expression) {
        if (expression.length() % 2 != 0) {
            return false;
        }
        if (!Character.isUpperCase(expression.charAt(0))) {
            return false;
        }
        if (!Character.isLowerCase(expression.charAt(expression.length() - 1))) {
            return false;
        }

        Stack<Character> letters = new Stack();

        for (char c : expression.toCharArray()) {
            if (c == 'A' || c == 'B' || c == 'C') {
                letters.push(c);
            } else if (c == 'a' || c == 'b' || c == 'c') {
                if (letters.empty()) {
                    return false;
                }

                Character top = letters.pop();

                if ((top == 'A' && c != 'a') || (top == 'B' && c != 'b')
                        || (top == 'C' && c != 'c')) {
                    return false;
                }
            }
        }
        return letters.empty();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter an expression:");
        String expression = scan.nextLine();
        System.out.println(isValidExpression(expression));
    }
}

