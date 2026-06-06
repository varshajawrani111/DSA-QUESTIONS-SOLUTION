package com.dsaproblems.varsha.dynammicProgramming;

public class PartitionSubsetWithMinimumSumDifference {

    public static int subsetSum(int[] arr){

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        int k = sum;
        boolean[][] dp = new boolean[arr.length][k+1];

        for(int i=0; i<arr.length; i++){
            dp[i][0] = true; //first base case if target is true
        }

        if(arr[0] <= k) dp[0][arr[0]] = true; //second base case if index is zero

        for(int i=1;i<arr.length;i++){ //for arr elements

            for(int j=1; j <= k; j++){ //for target

                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(arr[i] <= j){
                    pick = dp[i-1][j-arr[i]];
                }

                dp[i][j] = pick || notPick;
            }
        }

        //Now checking if last row of dp array which sums are possible
        int min = Integer.MAX_VALUE;
        for(int s1=0; s1 < k/2; s1++){ //Running till half of total sum because the subset will repeat in inverse way
            if(dp[arr.length-1][s1]){
                min  = Math.min(min,Math.abs((sum - s1) - s1)); //Maths.abs(s2-s1)
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,9};

        System.out.println(subsetSum(nums));
    }
}
