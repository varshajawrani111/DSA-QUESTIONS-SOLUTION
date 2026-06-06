package com.dsaproblems.varsha.dynammicProgramming;

public class CountSubsetsWithGivenSum {

    public static int countSubsetsWithGivenSumSpaceOptimized(int[] arr, int targetSum) {

        int[] prev = new int[targetSum+1];
        int[] curr = new int[targetSum+1];

        prev[0] = curr[0] = 1; //base case if target is zero

        if(arr[0] <= targetSum) prev[arr[0]] = 1; //base case if index is zero

        for(int i=1;i<arr.length;i++){ //for arr elements

            for(int j=1; j<=targetSum; j++){ //for target

                int notPick = prev[j];
                int pick = 0;
                if(arr[i] <= j){
                    pick = prev[j-arr[i]];
                }

                curr[j] = pick + notPick;
            }

            prev = curr.clone(); //important
        }

        return prev[targetSum];

    }

    public static int countSubsetsWithGivenSumRecursion(int[] arr, int index, int targetSum) {
        if(targetSum == 0)
            return 1;

        if(index == 0){
            return arr[0] == targetSum ? 1 : 0;
        }


        int notPick = countSubsetsWithGivenSumRecursion(arr,index-1, targetSum);
        int pick = 0;

        if(arr[index] <= targetSum)
            pick = countSubsetsWithGivenSumRecursion(arr,index-1, targetSum - arr[index]);

        return notPick + pick; //are we getting the subset by picking or not picking the element
    }

    public static int countSubsetsWithGivenSumTabulation(int[] arr, int[][] dp, int targetSum) {

        for(int i=0;i<arr.length;i++){
            dp[i][0] = 1; //first base case if target is true
        }

        if(arr[0] <= targetSum) dp[0][arr[0]] = 1; //second base case if index is zero

        for(int i=1;i<arr.length;i++){ //for arr elements

            for(int j=1; j<=targetSum; j++){ //for target

                int notPick = dp[i-1][j];
                int pick = 0;
                if(arr[i] <= j){
                    pick = dp[i-1][j-arr[i]];
                }

                dp[i][j] = pick + notPick;
            }
        }

        return dp[arr.length-1][targetSum];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        int targetSum = 6;

        int[][] dp = new int[arr.length][targetSum+1];

        System.out.println(countSubsetsWithGivenSumRecursion(arr,arr.length-1, targetSum));
        System.out.println(countSubsetsWithGivenSumTabulation(arr, dp, targetSum));
        System.out.println(countSubsetsWithGivenSumSpaceOptimized(arr,targetSum));
    }
}
