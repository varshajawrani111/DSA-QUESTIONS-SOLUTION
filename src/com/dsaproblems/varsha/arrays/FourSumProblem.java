package com.dsaproblems.varsha.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {

    public static List<List<Integer>> fourSum(int[] nums, long target) {

        List<List<Integer>> res = new ArrayList<>();

        //sorting the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            //skip the duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                //skip the duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }


                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                    if (sum < target) {
                        left++;
                    }
                    if (sum > target) {
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        long target = 0;

        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res);
    }
}
