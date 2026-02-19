package com.dsaproblems.varsha.strings;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String first = strs[0];

        for (int i = 0; i < first.length(); i++) { // this loop is running according to the length of the firstWord length
            char ch = first.charAt(i);

            for (int j = 1; j < strs.length; j++) { // this loop is running according to the length of the string array
                // If i is out of range OR mismatch found
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return first.substring(0, i); //if no prefix will be found then it will be subString(x,x) which will return empty string
                }
            }
        }
        return first; // first string is the prefix
    }

    public static void main(String[] args) {
        String[] strs = {"rat", "dog", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
