package com.dsaproblems.varsha.dynammicProgramming;

public class CountPartitionsWithGivenDifference {

    static int mod = (int)1e9+7;

    public static int countSubsetsWithGivenSum(int[] arr, int targetSum) {

        int[] prev = new int[targetSum+1];
        int[] curr = new int[targetSum+1];

        //base case if target is zero in this case we can have 0 also be in array that why this extra conditions
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= targetSum) prev[arr[0]] = 1; //base case if index is zero

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

        return prev[targetSum] % mod;

    }

    public static int countSubsetsWithGivenDifference(int[] arr, int diff) {
        int totalSum = 0;

        for (int j : arr) {
            totalSum += j;
        }

        if(totalSum - diff < 0 || (totalSum - diff) % 2 == 1) return 0;

        return countSubsetsWithGivenSum(arr, (totalSum - diff) / 2);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int diff = 3;
        System.out.println(countSubsetsWithGivenDifference(arr, diff));
    }
}
