package com.dsaproblems.varsha.strings;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        // Maps for both directions
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If mapping already exists, check if it is consistent
            if (map1[c1] != map2[c2]) {
                return false;
            }

            // Mark the mapping (i+1 to avoid default 0 conflict)
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
    }
}

