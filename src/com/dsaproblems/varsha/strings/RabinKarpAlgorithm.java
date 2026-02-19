package com.dsaproblems.varsha.strings;

public class RabinKarpAlgorithm {

    static int d = 26; //to convert integer into string
    static int q = 13; //random prime function for modulo

    public static void rabinKarp(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        int h = 1; // d^(m-1) % q
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text window

        // Compute h = pow(d, m-1) % q
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Compute initial hash of pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + (pattern.charAt(i) - 'a')) % q;
            t = (d * t + (text.charAt(i) - 'a')) % q;
        }

        // Slide pattern over text
        for (int s = 0; s <= n - m; s++) {

            // If hash matches, check characters one by one
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(s + j) != pattern.charAt(j))
                        break;
                }

                if (j == m) {
                    System.out.println("Pattern found at shift: " + s);
                }
            }

            // Calculate hash for next window
            if (s < n - m) {
                t = (d * (t - (text.charAt(s) - 'a') * h)
                        + (text.charAt(s + m) - 'a')) % q;

                // Make hash positive
                if (t < 0)
                    t = t + q;
            }
        }
    }

    public static void main(String[] args) {
        String text = "ababcababa";
        String pattern = "ababa";

        rabinKarp(text, pattern);
    }
}
