package com.dsaproblems.varsha.bitManuplation;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class MinimumXORValueInArray {

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        Arrays.sort(arr); //sort the array
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            minValue = Math.min(minValue,(arr[i] ^ arr[i+1]));
        }

        System.out.println(minValue);
    }
}
