package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class SearchInRotatedSortedArray extends CommonFunctionality {

    public static void main(String[] args) {

        int[] arr = getInputArray();

        System.out.println("Enter the target element:");
        int target = new Scanner(System.in).nextInt();

        int low = 0;
        int high = arr.length-1;

        int res = -1;

        while(low<=high){

            int mid = (low+high)/2;

            if(arr[mid]==target){
                res = mid;
                break;
            }

            if(arr[mid] >= arr[low]){ //left half is sorted
                if(arr[low]<=target && target<arr[mid] ){
                    high = mid-1; //left side
                } else{
                    low = mid+1; //right side
                }
            } else{ //right half is sorted
                if(arr[mid]<=target && target<arr[high]){
                    low = mid+1; //right side
                }else {
                    high = mid-1; //left side
                }
            }
        }

        System.out.println(res);
    }
}
