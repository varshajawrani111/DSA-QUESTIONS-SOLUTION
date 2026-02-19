package com.dsaproblems.varsha.bitManuplation;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class SingleNumberThree {

    public static int[] singleNumber(int[] arr) {

        long xr = 0;

        for (int i : arr) {
            xr ^= i;
        }

        long rightMostBit = xr & (xr-1) ^ xr;

        int b1 =0;
        int b2 =0;

        for (int j : arr) {
            if ((j & rightMostBit) == 0) {
                b1 ^= j;
            } else {
                b2 ^= j;
            }
        }

        return new int[]{b1,b2};
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        System.out.println(Arrays.toString(singleNumber(arr)));

    }
}
