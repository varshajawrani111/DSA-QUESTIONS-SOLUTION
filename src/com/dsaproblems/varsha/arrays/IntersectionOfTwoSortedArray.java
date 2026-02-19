package com.dsaproblems.varsha.arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArray extends CommonFunctionality{

    public static void main(String[] args) {

        System.out.println("Enter the elements in the first array");
        int[] arr1 = getInputArray();

        System.out.println("Enter the elements in the second array");
        int[] arr2 = getInputArray();

        List<Integer> result = new ArrayList<>();

        int n=Math.min(arr1.length,arr2.length);

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) { // as array is sorted all elements in arr2 will be greater thats why increasing i value
                i++;
            } else if (arr1[i] > arr2[j]) { //as array is sorted all elements in arr1 will be greater thats why increasing j value
                j++;
            } else {
                result.add(arr1[i]);
                i++;
                j++;
            }
        }



        System.out.println("Intersection of two arrays:");
        System.out.println(result);
    }
}
