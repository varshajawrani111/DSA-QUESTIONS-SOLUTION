package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastPositionOfElement extends CommonFunctionality {

    public static int findFirstOccurence(int[] arr, int target){
        int low =0;
        int high = arr.length-1;

        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]== target){
                ans = mid;
                high = mid-1;
            } else if(arr[mid]<target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }

        return ans;
    }

    public static int findLastOccurence(int[] arr, int target){
        int low =0;
        int high = arr.length-1;

        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]== target){
                ans = mid;
                low = mid+1;
            } else if(arr[mid]>target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = getInputArray();

        System.out.print("Enter the target Element: ");
        int target = new Scanner(System.in).nextInt();

        int first = findFirstOccurence(arr,target);
        int last = findLastOccurence(arr,target);

        int[] result = {first,last};

        System.out.println("First and last Occurence: "+ Arrays.toString(result));
    }
}
