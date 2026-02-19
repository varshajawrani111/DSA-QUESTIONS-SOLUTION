package com.dsaproblems.varsha.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZerostoEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] == 0 && arr[j] != 0) {
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
