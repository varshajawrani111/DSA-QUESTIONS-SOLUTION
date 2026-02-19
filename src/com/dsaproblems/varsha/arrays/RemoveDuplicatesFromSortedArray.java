package com.dsaproblems.varsha.arrays;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    static int removeDuplicates(int[] arr) {

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = removeDuplicates(arr);

        System.out.println("The array after removing duplicate elements is ");

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
