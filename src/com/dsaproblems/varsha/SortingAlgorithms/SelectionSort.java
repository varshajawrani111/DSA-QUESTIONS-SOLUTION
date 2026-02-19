package com.dsaproblems.varsha.SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            swap(arr, i, min_idx);
        }
    }

    public static void main(String[] args) {

        int[] arr = getInputArray();

        selectionSort(arr);

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
}
