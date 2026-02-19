package com.dsaproblems.varsha.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateAnArrayByOnePlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lastElement = arr[0];

        for (int i = 0; i < n-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[n-1] = lastElement;

        System.out.println(Arrays.toString(arr));
    }
}
