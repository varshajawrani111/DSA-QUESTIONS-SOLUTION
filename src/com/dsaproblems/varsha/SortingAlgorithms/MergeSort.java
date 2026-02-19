package com.dsaproblems.varsha.SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static int[] getInputArray() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array");
        System.out.println(Arrays.toString(arr));
        return arr;
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
        int[] arr = getInputArray();

        arr = mergeSort(arr);

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
}
