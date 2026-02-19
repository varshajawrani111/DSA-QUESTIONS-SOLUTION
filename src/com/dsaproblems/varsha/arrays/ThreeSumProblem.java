package com.dsaproblems.varsha.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

    public static List<List<Integer>> threeSum(int[] nums) {
        //Sorting the array
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            //skipping the duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;


            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    //skip further duplicated
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
