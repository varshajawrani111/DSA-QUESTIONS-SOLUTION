package com.dsaproblems.varsha.arrays;

import java.util.Scanner;

public class CheckIfArrayIsSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter the elements in the array");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean checkIfArrayIsSorted = true;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >=arr[i + 1]) {
                checkIfArrayIsSorted = false;
                break;
            }
        }

        System.out.println(checkIfArrayIsSorted);
    }
}
