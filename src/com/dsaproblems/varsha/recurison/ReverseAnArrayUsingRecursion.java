package com.dsaproblems.varsha.recurison;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class ReverseAnArrayUsingRecursion {

    private static void reverse(int[] arr, int low, int high) {

        //Base condtion
        if(low >= high)
            return;

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

        reverse(arr, low+1, high-1);
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        reverse(arr, 0, arr.length-1);

        System.out.println("Reversed Array:");
        System.out.println(Arrays.toString(arr));
    }
}