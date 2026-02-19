package com.dsaproblems.varsha.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateAnArrayByDPlace {

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void leftRotate(int arr[], int n, int d) {

        if (n == 0) return;

        // Get the effective number of rotations:
        d = d % n;

        //step 1: rotate first part of the array
        reverse(arr, 0, d - 1);

        //step 2: rotate second part of the array
        reverse(arr, d, n - 1);

        //step 3: rotate whole array
        reverse(arr, 0, n - 1);
    }

    //Doing this by using reversal algorithm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the values through which needs to be rotated");
        int d = sc.nextInt();

        leftRotate(arr, n, d);

        System.out.println(Arrays.toString(arr));
    }
}
