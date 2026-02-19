package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class MinimumInRotatedSortedArray extends CommonFunctionality {

    public static void main(String[] args) {

        int[] arr = getInputArray();

        int low = 0;
        int high = arr.length-1;

        while(low < high){

            int mid = (low+high)/2;

            if(arr[mid] > arr[high]){ //left half is sorted and we will find the minimum in right half
                low = mid+1;
            } else{
                high = mid;
            }
        }

        System.out.println(arr[low]); //this will return the minimum element
    }
}
