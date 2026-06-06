package com.dsaproblems.varsha.dynammicProgramming;

public class CoinChangeII {

    public static int minimumNumberOfWays(int[] nums, int target, int index) {

        //base case
        if(index == 0){

            if(target % nums[0] == 0){
                return 1;
            }
            else
                return 0;
        }

        int notPick = minimumNumberOfWays(nums, target, index-1);
        int pick = 0;

        if(nums[index] <= target){
            pick = minimumNumberOfWays(nums, target-nums[index], index);
        }

        return pick + notPick;
    }

    public static int minimumNumberOfWaysTabulation(int[] nums, int target, int index) {

        //base case
        int[][] dp = new int[nums.length][target+1];

        for(int t = 0; t <= target; t++){

            if(t % nums[0] == 0){
                dp[0][t] = 1;
            }
            else{
                dp[0][t] = 0;
            }

        }

        for(int i = 1; i < nums.length; i++){
            for(int t = 0; t <= target; t++){

                int notPick = dp[i-1][t];
                int pick = 0;

                if(nums[i] <= t){
                    pick = dp[i][t-nums[i]];
                }

                dp[i][t] = pick + notPick;
            }
        }

        return dp[index][target];
    }

    public static int minimumNumberOfWaysSpaceOtimization(int[] nums, int target) {

        //base case
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int t = 0; t <= target; t++){

            if(t % nums[0] == 0){
                prev[t] = 1;
            }
            else{
                prev[t] = 0;
            }

        }

        for(int i = 1; i < nums.length; i++){
            for(int t = 0; t <= target; t++){

                int notPick = prev[t];
                int pick = 0;

                if(nums[i] <= t){
                    pick = curr[t-nums[i]];
                }

                curr[t] = notPick + pick;
            }

            prev = curr.clone();

        }

        return prev[target];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 5;

        System.out.println(minimumNumberOfWays(coins, target, coins.length-1));
        System.out.println(minimumNumberOfWaysTabulation(coins, target, coins.length-1));
        System.out.println(minimumNumberOfWaysSpaceOtimization(coins, target));
    }
}
