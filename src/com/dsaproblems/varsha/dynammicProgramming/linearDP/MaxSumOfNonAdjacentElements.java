package com.dsaproblems.varsha.dynammicProgramming;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class MaxSumOfNonAdjacentElements {

    public static int maxSum(int[] nums){
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            int sum = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = sum;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = CommonFunctionality.getInputArray();

        System.out.println(maxSum(nums));
    }
}
