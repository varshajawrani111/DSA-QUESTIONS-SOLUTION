package com.dsaproblems.varsha.dynammicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

    public static int fibonacciMemoization(int n, int[] dp){

        if(n <= 1){
            return n;
        }

        //check if the subsequence is already computed
        if(dp[n] != -1){
            return dp[n];
        }

        //Store already calculated results
        return dp[n] = fibonacciMemoization(n-1, dp) + fibonacciMemoization(n-2, dp);
    }

    public static int fibonacciTabulation(int n, int[] dp){

        //Storing the base case
        dp[0]  = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int fibonacciSpaceOptimization(int n){

        int prev1 = 0;
        int prev2 = 1;

        for(int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(fibonacciMemoization(n, dp));

        Arrays.fill(dp, -1);
        System.out.println(fibonacciTabulation(n, dp));

        System.out.println(fibonacciSpaceOptimization(n));
    }
}
