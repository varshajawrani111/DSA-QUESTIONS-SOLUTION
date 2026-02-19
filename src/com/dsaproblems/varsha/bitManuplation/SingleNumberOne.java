package com.dsaproblems.varsha.bitManuplation;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class SingleNumberOne {

    public static int findSingleNumber(int[] arr){

        int res = 0;

        for (int i : arr) {
            res ^= i;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();
        System.out.println(findSingleNumber(arr));
    }
}
