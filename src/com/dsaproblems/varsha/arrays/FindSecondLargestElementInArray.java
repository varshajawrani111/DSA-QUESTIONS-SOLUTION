package com.dsaproblems.varsha.arrays;

import java.util.Scanner;

public class FindSecondLargestElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = -1;
        int secondMax = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {

                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        System.out.println(secondMax);
    }
}
