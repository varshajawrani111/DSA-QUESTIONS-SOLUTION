package com.dsaproblems.varsha.bitManuplation;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class SingleNumberTwo {

    public static int findSingleNumber(int[] arr){

         Arrays.sort(arr); // sorting will make same number appear collectively

        //will run the for loop and move three elements ahead and to get in the middle position of element which appears thrice
        //and check if the element before it is same or not
        //it will return the single element if it appears at the start of the array also
        for(int i=1;i<arr.length;i += 3 ){

            if(arr[i]!=arr[i-1]){
                return arr[i-1];
            }
        }

        return arr[arr.length-1]; //if the single element is at the end of the array
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();
        System.out.println(findSingleNumber(arr));

    }
}
