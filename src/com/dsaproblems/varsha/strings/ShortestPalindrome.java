package com.dsaproblems.varsha.strings;

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString(); //reversing the string

        StringBuilder temp = new StringBuilder(s + "#" + rev); //temporary string

        int[] lps = LongestPrefixSufix.buildLPString(temp.toString()); //calculating LPS array of temp

        int longestPalindromePrefix = lps[lps.length - 1]; //of the string is already palindromic it will return the length of string

        String add = s.substring(longestPalindromePrefix);
        //this will return the substring from index longestCommonPrefix till end that need to be added to make string palindrome
        //substring(end,end) will return empty string in case the string is already palindromic

        return new StringBuilder(add).reverse().toString() + s;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(shortestPalindrome("abcd"));     // dcbabcd
    }
}
