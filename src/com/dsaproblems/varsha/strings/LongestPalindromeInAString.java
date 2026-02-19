package com.dsaproblems.varsha.strings;

public class LongestPalindromeInAString {

    public static int checkPalindrome(String str, int left, int right) {

        int l = left, r = right;

        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            //this will run until we are getting the same character around the middle of the palindrome substring
            l--;
            r++;
        }

        return r - l - 1;
    }

    public static String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;

        for(int i = 0; i < str.length(); i++) {

            int len1 = checkPalindrome(str, i, i); //if string is of odd length
            int len2 = checkPalindrome(str, i, i + 1); //if string is of even length
            int len = Math.max(len1, len2);

            if(len > right-left) {

                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        return str.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
}
