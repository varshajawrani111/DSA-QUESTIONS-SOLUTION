package com.dsaproblems.varsha.dynammicProgramming;

public class TargetSum {

    public static int countSubsetsWithGivenSum(int[] arr, int targetSum) {

        int[] prev = new int[targetSum+1];
        int[] curr = new int[targetSum+1];

        // base case
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= targetSum)
            prev[arr[0]] = 1;

        for(int i = 1; i < arr.length; i++){

            for(int j = 0; j <= targetSum; j++){

                int notPick = prev[j];
                int pick = 0;

                if(arr[i] <= j)
                    pick = prev[j-arr[i]];

                curr[j] = pick + notPick;
            }

            prev = curr;
        }

        return prev[targetSum];
    }

    public static int countSubsetsWithGivenDifference(int[] arr, int target) {
        int totalSum = 0;

        for (int j : arr) {
            totalSum += j;
        }

        if(totalSum - target < 0 || (totalSum - target) % 2 == 1) return 0;

        return countSubsetsWithGivenSum(arr, (totalSum - target) / 2);
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1};
        int targetSum = 3;

        System.out.println(countSubsetsWithGivenDifference(arr, targetSum));
    }
}
