package com.dsaproblems.varsha.dynammicProgramming;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class SubsetSumEqualToTarget {

    public static boolean subsetSumEqualRecursion(int[] arr, int index, int targetSum) {
        if(targetSum == 0)
            return true;

        if(index == 0)
            return arr[0] == targetSum;

        boolean notPick = subsetSumEqualRecursion(arr,index-1, targetSum);
        boolean pick = false;

        if(arr[index] <= targetSum)
            pick = subsetSumEqualRecursion(arr,index-1, targetSum - arr[index]);

        return notPick || pick; //are we getting the subset by picking or not picking the element
    }

    public static boolean subsetSumEqualTabulation(int[] arr, boolean[][] dp, int targetSum) {

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

    public static boolean subsetSumEqualSpaceOptimization(int[] arr, int targetSum) {

        boolean[] prev = new boolean[targetSum+1];
        boolean[] curr = new boolean[targetSum+1];

        prev[0] = curr[0] =true; //base case if target is zero

        if(arr[0] <= targetSum) prev[arr[0]] = true; //base case if index is zero

        for(int i=1;i<arr.length;i++){ //for arr elements

            for(int j=1; j<=targetSum; j++){ //for target

                boolean notPick = prev[j];
                boolean pick = false;
                if(arr[i] <= j){
                    pick = prev[j-arr[i]];
                }

                curr[j] = pick || notPick;
            }

            prev = curr;
        }

        return prev[targetSum];
    }

    public static void main(String[] args) {
        int[] arr = CommonFunctionality.getInputArray();
        int target = new Scanner(System.in).nextInt();

        boolean[][] dp = new boolean[arr.length][target+1];

        System.out.println(subsetSumEqualRecursion(arr, arr.length-1, target));
        System.out.println(subsetSumEqualTabulation(arr, dp, target));
        System.out.println(subsetSumEqualSpaceOptimization(arr, target));
    }
}
