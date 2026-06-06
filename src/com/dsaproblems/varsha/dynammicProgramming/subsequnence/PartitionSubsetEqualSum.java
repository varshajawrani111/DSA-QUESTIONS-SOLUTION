package com.dsaproblems.varsha.dynammicProgramming;

public class PartitionSubsetEqualSum {

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) //if the
            return false;

        int target = sum / 2; //this will be the target for the subset

        //from here the problem is same as subset sum problem we have array and a target
        boolean[][] dp = new boolean[nums.length][target+1];

        return subsetSumEqual(nums,dp,target);
    }

    public static boolean subsetSumEqual(int[] arr, boolean[][] dp, int targetSum) {

        for(int i=0;i<arr.length;i++){
            dp[i][0] = true; //first base case if target is true
        }

        if(arr[0] <= targetSum) dp[0][arr[0]] = true; //second base case if index is zero

        for(int i=1;i<arr.length;i++){ //for arr elements

            for(int j=1; j<=targetSum; j++){ //for target

                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(arr[i] <= j){
                    pick = dp[i-1][j-arr[i]];
                }

                dp[i][j] = pick || notPick;
            }
        }

        return dp[arr.length-1][targetSum];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,11,5};

        System.out.println(canPartition(arr));
    }
}
