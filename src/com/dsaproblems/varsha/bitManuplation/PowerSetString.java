package com.dsaproblems.varsha.bitManuplation;

import java.util.*;

public class PowerSetString {

    public static List<String> powerSet(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        int total = 1 << n; // 2^n

        for (int mask = 0; mask < total; mask++) {
            StringBuilder subset = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.append(s.charAt(i));
                }
            }

            res.add(subset.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
}

