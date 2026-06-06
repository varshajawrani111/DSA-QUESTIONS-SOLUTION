package com.dsaproblems.varsha.dynammicProgramming;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class MinimumCostToClimbStairs {

    public static int minimumCostToClimbStairs(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int next = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = next;
        }

        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        int[] cost = CommonFunctionality.getInputArray();

        System.out.println(minimumCostToClimbStairs(cost));
    }
}
