package com.dsaproblems.varsha.arrays;

import static java.lang.Math.max;

public class MaximumProductSubarray {

    public static int maximumProductSubarray(int[] nums) {

        int n = nums.length;

        int prefix = 1;
        int suffix = 1;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if(prefix == 0)
                prefix = 1;

            if(suffix == 0)
                suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n-i-1];

            max = Math.max(max, max(prefix,suffix));
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,-2,4};
        System.out.println(maximumProductSubarray(arr));
    }
}
