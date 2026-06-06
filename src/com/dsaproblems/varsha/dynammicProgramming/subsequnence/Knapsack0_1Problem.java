package com.dsaproblems.varsha.dynammicProgramming;

public class Knapsack0_1Problem {

    public static int knapsack01Recursion(int[] weight, int[] profit, int capacity, int index) {

        if (index == 0) {
            if(weight[0] <= capacity) {
                return profit[0];
            }
            else  {
                return 0;
            }
        }

        int notTake = knapsack01Recursion(weight, profit, capacity, index - 1);
        int take = Integer.MIN_VALUE;

        if(weight[index] <= capacity) {
            take = profit[index] +
                    knapsack01Recursion(weight, profit, capacity-weight[index], index - 1);
        }

        return Math.max(notTake, take);

    }

    public static int knapsack01Tabulation(int[] weight, int[] profit, int capacity, int index) {

        int[][] dp = new int[weight.length][capacity+1];

        //base case when index is o
        for(int w = weight[0]; w <= capacity; w++) {
            dp[0][w] = profit[0];
        }

        for(int i = 1; i < weight.length; i++) {
            for(int w = 0; w <= capacity; w++) {

                int notTake = dp[i-1][w];
                int take = Integer.MIN_VALUE;

                if(weight[i] <= w) {
                    take = profit[i] + dp[i-1][w-weight[i]];
                }

                dp[i][w] = Math.max(take, notTake);

            }
        }

        return dp[index][capacity];
    }

    public static int knapsack01SpaceOptimization(int[] weight, int[] profit, int capacity) {

        int[] prev = new int[capacity+1];

        //base case when index is o
        for(int w = weight[0]; w <= capacity; w++) {
            prev[w] = profit[0];
        }

        for(int i = 1; i < weight.length; i++) {
            for(int w = capacity; w >= 0; w--) {

                int notTake = prev[w];
                int take = Integer.MIN_VALUE;

                if(weight[i] <= w) {
                    take = profit[i] + prev[w-weight[i]];
                }

                prev[w] = Math.max(take, notTake);
            }
        }

        return prev[capacity];
    }

    public static void main(String[] args) {

        int[] weight = {1,2,4,5};
        int[] profit = {5,4,8,6};
        int capacity = 5;

        int n = weight.length;

        System.out.println(knapsack01Recursion(weight, profit, capacity, n-1));
        System.out.println(knapsack01Tabulation(weight, profit, capacity, n-1));
        System.out.println(knapsack01SpaceOptimization(weight, profit, capacity));

    }


}
