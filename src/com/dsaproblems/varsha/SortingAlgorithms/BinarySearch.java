package com.dsaproblems.varsha.SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch extends QuickSort {

    private static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = getInputArray();

        System.out.println("Enter the target number");
        int target = new Scanner(System.in).nextInt();

        quickSort(arr);

        System.out.println("Sorted array is:");
        System.out.println(Arrays.toString(arr));

        int index = binarySearch(arr, target);

        System.out.println(index);

    }
}
