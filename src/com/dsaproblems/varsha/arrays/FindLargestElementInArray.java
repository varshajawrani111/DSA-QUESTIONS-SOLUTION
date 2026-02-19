package com.dsaproblems.varsha.arrays;

import java.util.Scanner;

public class FindLargestElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
         for (int i = 1; i < n; i++) {
             if (arr[i] > max) {
                 max = arr[i];
             }
         }

        System.out.println(max);
    }
}
