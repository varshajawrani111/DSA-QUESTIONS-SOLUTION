package com.dsaproblems.varsha.dynammicProgramming;

import java.util.Arrays;

public class CoinChangeI {

    public static int minimumNumberOfCoins(int[] nums, int target, int index) {

        //base case
        if(index == 0){

            if(target % nums[0] == 0){
                return target/nums[0]; //how many coins can be taken to achieve the target
            }
            else
                return (int) (1e9);
        }

        int notPick = minimumNumberOfCoins(nums, target, index-1);
        int pick = Integer.MAX_VALUE;

        if(nums[index] <= target){
            pick = 1 + minimumNumberOfCoins(nums, target-nums[index], index);
        }

        return Math.min(pick,notPick);
    }

    public static int minimumNumberOfCoinsTabulation(int[] nums, int target, int index) {

        //base case
        int[][] dp = new int[nums.length][target+1];

        for(int t = 0; t <= target; t++){

            if(t % nums[0] == 0){
                dp[0][t] = t/nums[0];
            }
            else{
                dp[0][t] = (int)1e9;
            }

        }

        for(int i = 1; i < nums.length; i++){
            for(int t = 0; t <= target; t++){

                int notPick = dp[i-1][t];
                int pick = Integer.MAX_VALUE;

                if(nums[i] <= t){
                    pick = 1 + dp[i][t-nums[i]];
                }

                dp[i][t] = Math.min(pick, notPick);
            }
        }

        int ans = dp[index][target];
        if(ans >= 1e9){
            return -1;
        }
        return ans;
    }

    public static int minimumNumberOfCoinsSpaceOtimization(int[] nums, int target) {

        //base case
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int t = 0; t <= target; t++){

            if(t % nums[0] == 0){
                prev[t] = t/nums[0];
            }
            else{
                prev[t] = (int)1e9;
            }

        }

        for(int i = 1; i < nums.length; i++){
            for(int t = 0; t <= target; t++){

                int notPick = prev[t];
                int pick = Integer.MAX_VALUE;

                if(nums[i] <= t){
                    pick = 1 + curr[t-nums[i]];
                }

                curr[t] = Math.min(pick, notPick);
            }

            prev = curr.clone();

        }

        int ans = prev[target];
        if(ans >= 1e9){
            return -1;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 11;

        System.out.println(minimumNumberOfCoins(coins, target, coins.length-1));
        System.out.println(minimumNumberOfCoinsTabulation(coins, target, coins.length-1));
        System.out.println(minimumNumberOfCoinsSpaceOtimization(coins, target));
    }



}
