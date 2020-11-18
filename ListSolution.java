package com.natali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListSolution {

    private static boolean isValidExpression(String input) {
        if (input.length() % 2 != 0 || input.length() == 0) {
            return false;
        }

        List<Character> letters = new ArrayList<>();

        for (char c : input.toCharArray()) {
            letters.add(c);
        }

        if (!Character.isUpperCase(letters.get(0))) {
            return false;
        }
        if (!Character.isLowerCase(letters.get(letters.size() - 1))) {
            return false;
        }
        for (int i = 1; i < letters.size(); i++) {
            char smallLetter = letters.get(i);
            if (Character.isLowerCase(smallLetter)) {

                if (i > 0) {
                    char capitalLetter = letters.get(i - 1);
                    char testLetter = Character.toLowerCase(capitalLetter);
                    if (smallLetter == testLetter) {
                        letters.remove(i);
                        letters.remove(i - 1);
                        i = 0;
                    } else {
                        return false;
                    }
                }
            }
        }
        return letters.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter an expression:");
        String expression = scan.nextLine();
        System.out.println(isValidExpression(expression));
    }
}
