package com.dsaproblems.varsha.arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArray extends CommonFunctionality{

    public static void main(String[] args) {

        System.out.println("Enter the elements in the first array");
        int[] arr1 = getInputArray();

        System.out.println("Enter the elements in the second array");
        int[] arr2 = getInputArray();

        List<Integer> result = new ArrayList<>();

        int i=0;
        int j=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                result.add(arr1[i]);
                i++;
            }else{
                result.add(arr2[j]);
                j++;
            }
        }

        while(i<arr1.length){
            result.add(arr1[i]);
            i++;
        }
        while(j<arr2.length){
            result.add(arr2[j]);
            j++;
        }

        System.out.print("Union of sorted array");
        System.out.print(result.toString());
    }
}
