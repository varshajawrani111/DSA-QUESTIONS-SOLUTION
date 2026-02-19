package com.dsaproblems.varsha.arrays;

import java.util.Arrays;

public class MajorityElement_BoyerNooreVotingAlgo {

    public static int majorityElement(int[] nums) {

        int count= 0;
        int candidate = 0;

        for(int num:nums){

            if(count==0){ //if count becomes zero change the candidate
                candidate = num;
            }

            if(candidate == num){
                count++;
            }
            else{
                count--;
            }

        }

        //verifying if the candidate is the majority element
        //if problem states that majority element always exists no need ot write this step
        int freq = 0;
        for(int num:nums){
            if(num == candidate){
                freq++;
            }
        }

        if(freq > (nums.length/2)){
            return candidate;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,1};

        System.out.println(majorityElement(arr));
    }
}
