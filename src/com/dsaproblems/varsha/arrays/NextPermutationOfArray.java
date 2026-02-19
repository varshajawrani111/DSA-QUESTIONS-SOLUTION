package com.dsaproblems.varsha.arrays;

import java.util.Arrays;

public class NextPermutationOfArray extends CommonFunctionality{

    public static void main(String[] args) {

        int[] arr = getInputArray();

        //initializing pivot to -1
        int pivot = -1;

        //finding the pivot which satisfies arr[i]<arr[i+1]
        for (int i= arr.length-2;i>=0;i--){
            if (arr[i] < arr[i+1]){
                pivot = i;
                break;  
            }
        }

        //if array is in descending order will reverse hte whole array
        if (pivot == -1){
            reverse(arr, pivot + 1, arr.length-1);
        }
        else{
            for(int i= arr.length-1;i>=0;i--){
                if (arr[i] > arr[pivot]){
                    swap(arr, pivot, i); //swaping the first most greater element from pivot
                    break;
                }
            }

            reverse(arr, pivot + 1, arr.length-1);
        }

        System.out.println("Next Permutation is " + Arrays.toString(arr));
    }
}
