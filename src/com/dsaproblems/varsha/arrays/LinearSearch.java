package com.dsaproblems.varsha.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the key");
        int key = sc.nextInt();

        int index = -1;
        for (int i = 1; i < n; i++) {

            if (arr[i] == key) {
              index = i;
              break;
            }

        }

        System.out.println(index);
    }
}
