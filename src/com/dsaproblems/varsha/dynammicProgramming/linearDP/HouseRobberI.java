package com.dsaproblems.varsha.dynammicProgramming;

import com.dsaproblems.varsha.Main;
import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class HouseRobberI {

    public static int houseRobber(int[] nums){
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            int next = Math.max(nums[i] + prev2, prev1);

            prev2 = prev1;
            prev1 = next;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = CommonFunctionality.getInputArray();

        System.out.println(houseRobber(nums));
    }
}
