package com.dsaproblems.varsha.dynammicProgramming;

import java.util.Scanner;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        System.out.println(climbStairs(n));

    }
}
