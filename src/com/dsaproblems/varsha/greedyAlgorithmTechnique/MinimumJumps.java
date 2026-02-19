package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class MinimumJumps {

    public static int minJumps(int[] nums) {

        int n = nums.length;


        if (n <= 1) return 0;

        int jumps = 0;
        int currEnd = 0;
        int maxReach = 0;

        for (int i = 0; i < n - 1; i++) {

            maxReach = Math.max(maxReach, i + nums[i]);

            // Early stop 🚀
            if (maxReach >= n - 1) {
                return jumps + 1;  // we will need one more jump
            }

            // If we reach the end of current range:
            if (i == currEnd) {
                jumps++;
                currEnd = maxReach;
            }
        }
        return jumps;
    }


    public static void main(String[] args) {

        System.out.println("Enter the jump array: ");
        int[] arr = CommonFunctionality.getInputArray();

        System.out.println("Minimum jumps required to reach the last index are: " + minJumps(arr));

    }
}
