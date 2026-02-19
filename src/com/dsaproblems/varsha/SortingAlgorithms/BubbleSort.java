package com.dsaproblems.varsha.SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

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

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        boolean swapped = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if(!swapped) // to avoid unwanted loops as array is almost sorted
                    break;
        }
    }

    public static void main(String[] args) {

        int[] arr = getInputArray();

        bubbleSort(arr);

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));

    }
}
