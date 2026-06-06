package com.dsaproblems.varsha.dynammicProgramming;

public class RodCuttingProblem {

    public static int maximumValueByRodCuttingRecursion(int N, int[] profit, int index) {

        if(index == 0){
            return N * profit[0];
            //this means we require N rods of length 1 multiplied by its profit as at index 0 rod length is one
        }

        int notPick = maximumValueByRodCuttingRecursion(N, profit, index-1);
        //length will remian same and we will move to previous inde
        int pick = Integer.MIN_VALUE;

        if(index+1 <= N){
            pick = profit[index] + maximumValueByRodCuttingRecursion(N-(index+1), profit, index);
        }

        return Math.max(notPick,pick);
    }

    public static int maximumValueByRodCuttingTabulation(int N, int[] profit, int index) {

        int[][] dp = new int[N][N+1];

        //base case when index is o
        for(int n = 0; n <= N; n++) {
            dp[0][n] = n * profit[0];
        }

        for(int i = 1; i < N; i++) {
            for(int n = 0; n <= N; n++) {

                int notTake = dp[i-1][n];
                int take = Integer.MIN_VALUE;

                if(i+1 <= n) {
                    take = profit[i] + dp[i][n-(i+1)]; //i+1 is the rod length
                }

                dp[i][n] = Math.max(take, notTake);

            }
        }

        return dp[index][N];
    }

    public static int maximumValueByRodCuttingSpaceOptimization(int N ,int[] profit) {

        int[] prev = new int[N+1];

        //base case when index is o
        for(int n = 0; n <= N; n++) {
            prev[n] = n * profit[0];
        }

        for(int i = 1; i < N; i++) {
            for(int n = 0; n <= N; n++) {

                int notTake = prev[n];
                int take = Integer.MIN_VALUE;

                if((i+1) <= n) {
                    take = profit[i] + prev[n-(i+1)];
                }

                prev[n] = Math.max(take, notTake);
            }
        }

        return prev[N];
    }

    public static void main(String[] args) {

        int[] profit = {1,5,8,9,10,17,17,20};

        int n = profit.length;

        System.out.println(maximumValueByRodCuttingRecursion(n,profit, n-1));
        System.out.println(maximumValueByRodCuttingTabulation(n, profit, n-1));
        System.out.println(maximumValueByRodCuttingSpaceOptimization(n, profit));

    }
}
