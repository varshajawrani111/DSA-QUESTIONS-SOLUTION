package com.dsaproblems.varsha.dynammicProgramming;

public class UnboundedKnapsackProblem {


    public static int unboundedKnapsackRecursion(int[] weight, int[] profit, int capacity, int index) {

        if (index == 0) {
            return (capacity/weight[0]) * profit[0];
            //how many times remaining weight can be added multiplied by its profit
        }

        int notTake = unboundedKnapsackRecursion(weight, profit, capacity, index - 1);
        int take = Integer.MIN_VALUE;

        if(weight[index] <= capacity) {
            take = profit[index] +
                    unboundedKnapsackRecursion(weight, profit, capacity-weight[index], index); //keeping the index as infinite supply
        }

        return Math.max(notTake, take);

    }

    public static int unboundedKnapsackTabulation(int[] weight, int[] profit, int capacity, int index) {

        int[][] dp = new int[weight.length][capacity+1];

        //base case when index is o
        for(int w = 0; w <= capacity; w++) {
            dp[0][w] = (w/weight[0]) * profit[0];
        }

        for(int i = 1; i < weight.length; i++) {
            for(int w = 0; w <= capacity; w++) {

                int notTake = dp[i-1][w];
                int take = Integer.MIN_VALUE;

                if(weight[i] <= w) {
                    take = profit[i] + dp[i][w-weight[i]];
                }

                dp[i][w] = Math.max(take, notTake);

            }
        }

        return dp[index][capacity];
    }

    public static int unboundedKnapsackSpaceOptimization(int[] weight, int[] profit, int capacity) {

        int[] prev = new int[capacity+1];

        //base case when index is o
        for(int w = 0; w <= capacity; w++) {
            prev[w] = (w/weight[0]) * profit[0];
        }

        for(int i = 1; i < weight.length; i++) {
            for(int w = 0; w <= capacity; w++) {

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

        int[] weight = {2,4,6};
        int[] profit = {5,11,13};
        int capacity = 10;

        int n = weight.length;

        System.out.println(unboundedKnapsackRecursion(weight, profit, capacity, n-1));
        System.out.println(unboundedKnapsackTabulation(weight, profit, capacity, n-1));
        System.out.println(unboundedKnapsackSpaceOptimization(weight, profit, capacity));

    }

}
