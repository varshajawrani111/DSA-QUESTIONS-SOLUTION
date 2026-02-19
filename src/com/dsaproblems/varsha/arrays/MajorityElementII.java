package com.dsaproblems.varsha.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {

        int count1 =0;
        int count2 =0;
        int candidate1 = 0;
        int candidate2 = 0;

        //this pass will give us the candidate one and candidate 2
        for (int num : nums) {

            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = num;
            }
            else if(count2 == 0){
                candidate2 = num;
            }
            else{
                count1--;
                count2--;
            }
        }

        //verifying if both the candidates are majority element
        count1 = 0;
        count2 = 0;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            if(num == candidate1){
                count1++;
            }else if(num == candidate2){
                count2++;
            }
        }

        if(count1 > nums.length/3){
            res.add(candidate1);
        }
        if(count2 > nums.length/3){
            res.add(candidate2);
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));

    }
}
