package com.dsaproblems.varsha.strings;

public class MinimumCharactersToAddToMakeStringPalindrome {

    public static int minCharsToAdd(String s) {

        String rev = new StringBuilder(s).reverse().toString(); //reversing the string

        StringBuilder temp = new StringBuilder(s + "#" + rev); //temporary string

        int[] lps = LongestPrefixSufix.buildLPString(temp.toString()); //calculating LPS array of temp

        int longestPalindromePrefix = lps[lps.length - 1]; //of the string is already palindromic it will return the length of string

        String add = s.substring(longestPalindromePrefix);
        //this will return the substring from index longestCommonPrefix till end that need to be added to make string palindrome
        //substring(end,end) will return empty string in case the string is already palindromic

        return add.length(); //minimum length of characters to add
    }

    public static void main(String[] args) {
        System.out.println(minCharsToAdd("aacecaaa")); // aaacecaaa
        System.out.println(minCharsToAdd("abcd"));     // dcbabcd
    }
}
