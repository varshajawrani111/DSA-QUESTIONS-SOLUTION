package com.dsaproblems.varsha.dynammicProgramming;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class HouseRobberII {

    public static int houseRoober(int[] nums){

        int n = nums.length;

        if(n == 1) return nums[0]; //only one element in the array

        int case1 = rangeSolve(nums, 0, n-2); //pick first element and exclude last one
        int case2 = rangeSolve(nums, 1, n-1); //exclude first element and pic last one

        return Math.max(case1, case2);
    }

    public static int rangeSolve(int[] nums, int start, int end){
        int prev2 = 0;
        int prev1 = 0;

        for(int i = start; i <= end; i++){
            int next = Math.max(nums[i] + prev2, prev1);

            prev2 = prev1;
            prev1 = next;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = CommonFunctionality.getInputArray();

        System.out.println(houseRoober(nums));
    }
}
