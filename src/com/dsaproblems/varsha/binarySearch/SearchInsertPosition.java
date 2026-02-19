package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class SearchInsertPosition extends CommonFunctionality {
    public static void main(String[] args) {

        int[] arr = getInputArray();

        System.out.println("Enter the target element");
        int target = new Scanner(System.in).nextInt();

        int low = 0;
        int high = arr.length-1;
        int ans = arr.length; //assuming the target is inserted at the end

        //we will solve this question same as lower boud becuase in that also we are findingthe index for element >= target
        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]>=target){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }

        System.out.println("Insert position is : "+ ans);
    }
}
