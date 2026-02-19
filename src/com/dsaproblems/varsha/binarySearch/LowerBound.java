package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class LowerBound extends CommonFunctionality {

    public static void main(String[] args) {

        int[] arr = getInputArray();

        System.out.println("Enter the targte element");
        int target = new Scanner(System.in).nextInt();

        int low = 0;
        int high = arr.length-1;
        int ans = arr.length; //if no element is found like that it the ans will be length of the array

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]>=target){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }

        System.out.println("Lower bound of the target is : "+ans);
    }
}
