package com.dsaproblems.varsha.SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    private static int[] getInputArray() {
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


    public static void insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j-1;
            }

            arr[j+1] = key;
        }

    }

    public static void main(String[] args) {

        int[] arr = getInputArray();

        insertionSort(arr);

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
}
