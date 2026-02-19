package com.dsaproblems.varsha.strings;

public class CheckIfStringISRotationOfAnother {

    public static boolean checkIfStringIsRotationOfAnother(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String combined = s1 + s1;

        return combined.contains(s2);
        //it is ok to use the direct contains() method if not explicitly mentioned in question
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cba";

        System.out.println(checkIfStringIsRotationOfAnother(s1, s2));
    }
}
