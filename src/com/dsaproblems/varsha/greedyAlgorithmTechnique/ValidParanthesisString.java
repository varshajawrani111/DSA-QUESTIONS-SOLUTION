package com.dsaproblems.varsha.greedyAlgorithmTechnique;

public class ValidParanthesisString {

    public static boolean checkValidString(String s) {

        int minOpen = 0;  // Minimum possible '(' count
        int maxOpen = 0;  // Maximum possible '(' count

        for (char c : s.toCharArray()) {

            if (c == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // c == '*'
                // '*' can be '(', ')' or empty
                minOpen--;   // treat '*' as ')'
                maxOpen++;   // treat '*' as '('
            }

            // If leftMax becomes negative → too many ')'
            if (maxOpen < 0) {
                return false;
            }

            // leftMin should never be negative
            // Because we can't have negative '('
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // If minimum '(' is zero → possible to balance
        return minOpen == 0;
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));  // Output: true
    }
}

