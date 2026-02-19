package com.dsaproblems.varsha.binarySearch;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;
import java.util.Scanner;

public class FloorAndCeilInSortedArray extends CommonFunctionality {

    public static void main(String[] args) {

        int[] arr = getInputArray();

        System.out.println("Enter the number for floor and ceil in array : ");
        int target = new Scanner(System.in).nextInt();

        int floor = -1;
        int ceil = -1;

        int low = 0;
        int high = arr.length-1;

        int[] result = new int[2];


        while(low<=high){

            int mid = (low+high)/2;

            if(arr[mid] ==  target){
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }

            if(arr[mid] < target){
                low = mid+1; //go right to find next smaller element as all elements at left will be smaller than arr[mid]
                floor = arr[mid]; // this might be floor
            }else{
                high = mid-1; // to left to find the previous larger element as all elements at right will be greater than arr[mid]
                ceil = arr[mid];
            }
        }

        result[0] = floor;
        result[1] = ceil;

        System.out.println("Floor and ceil in array : "+ Arrays.toString(result));
    }
}
