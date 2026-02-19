package com.dsaproblems.varsha.strings;

public class ReverseWordsInTheStringWithoutSplitFunction {

    public static String reverseWords(String s) {

            StringBuilder result = new StringBuilder();
            int i = s.length() - 1;

            while (i >= 0) {
                // skip trailing spaces
                while (i >= 0 && s.charAt(i) == ' ')
                    i--;

                if (i < 0)
                    break;

                // mark the end of the word
                int end = i;

                // move left until a space is found
                while (i >= 0 && s.charAt(i) != ' ')
                    i--;

                // now substring is a word
                if (result.length() > 0)
                    result.append(" ");

                result.append(s.substring(i + 1, end + 1));
            }

            return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello   world  "));
        // Output: world hello
    }
}
