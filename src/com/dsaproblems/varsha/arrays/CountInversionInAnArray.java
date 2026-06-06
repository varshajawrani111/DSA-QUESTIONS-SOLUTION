package com.dsaproblems.varsha.arrays;

import java.util.Arrays;

public class CrossInversionInAnArray {

    static int count = 0;

    public static int crossInversion(int[] arr) {
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

        int[] result = merge(left, right);
        return result;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            }

            //right is smaller then we will be increasing the count of inversion pair
            else {
                result[k] = right[j];
                int mid = left.length -1;
                count +=  mid - i + 1; //this will give the number of elements in the left which are greater than right
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

        int[] arr = {2,4,1,3,5};
        System.out.println(crossInversion(arr));
    }
}
