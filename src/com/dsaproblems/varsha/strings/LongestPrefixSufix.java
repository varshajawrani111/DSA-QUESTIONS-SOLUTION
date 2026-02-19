package com.dsaproblems.varsha.strings;

public class LongestPrefixSufix {

    //Algorithm to build the lps(longest prefix suffix array)
    public static int[] buildLPString(String s){

        int[] ans = new int[s.length()];

        ans[0] = 0;
        int len = 0;
        int  i =1;

        while(i<s.length()){
            //if characters match
            if(s.charAt(i) == s.charAt(len)){
                len++;
                ans[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = ans[len-1]; // try f0r the smaller prefix
                }
                else {
                    ans[i] = 0;
                    i++;
                }

            }
        }

        return ans;
    }

    public static void KMPAlgorithm(String text, String pattern){

        //get the lps array of the pattern
        int[] lp = buildLPString(pattern);

        int  i = 0; //index for the text
        int j =  0; //index for the pattern

        while(i<text.length()){

            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

            if ( j == pattern.length()) {
                System.out.println("Pattern found at: " + (i - j));
                j = lp[j - 1]; //move for further searching
            }
            // mismatch after some matches
            else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lp[j - 1]; // jump to using LPS
                } else {
                    i++;
                }

            }

        }
    }

    public static void main(String[] args) {

        String text = "ababcababa";
        String pattern = "ababa";

        KMPAlgorithm(text, pattern);
    }
}
