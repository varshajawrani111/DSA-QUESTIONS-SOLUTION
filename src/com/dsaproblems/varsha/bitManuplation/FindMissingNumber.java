package com.dsaproblems.varsha.bitManuplation;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class FindMissingNumber {

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        int xorOfAllElements = XOROfNumbersFrom1ToN.XOROfNumbers(arr.length);

        for (int num : arr) {

            xorOfAllElements ^= num; //same elements will cancel out and missing number will be remained
        }

        System.out.println(xorOfAllElements);
    }
}
