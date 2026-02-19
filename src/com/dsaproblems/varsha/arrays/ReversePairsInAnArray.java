package com.dsaproblems.varsha.arrays;

import java.util.Arrays;

public class ReversePairsInAnArray {

    static int count = 0;

    public static int reversePairs(int[] arr) {
        count = 0; //just for safety we are initializing the count
        mergeSort(arr);
        return count;
    }

    public static int[] mergeSort(int[] arr) {

        if(arr.length <= 1) {
            return arr;
        }

        int n = arr.length;

        int mid = n/2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        left = mergeSort(left);
        right = mergeSort(right);

        //counting the reverse pairs before merging
        countReversePairs(left, right);

        return merge(left, right);
    }

    public static void countReversePairs(int[] left, int[] right) {

        int j = 0;

        for (int i : left) {
            while (j < right.length && (long) i > 2L * right[j]) {
                j++;
            }

            count += j;
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            }
            else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        System.out.println(reversePairs(arr));
    }
}
