package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class SearchInRotatedSortedArrayWithDuplicates extends CommonFunctionality {

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

            if(arr[low] == arr[high]){ //shrinking the boudaries as duplicates are there
                low++;
                high--;
                continue;
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

        System.out.println(res>=0); // to return true or false if element is there or not
    }
}
