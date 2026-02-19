package com.dsaproblems.varsha.basicMaths;

import java.util.Scanner;

public class CheckPrimeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number");
        int n = sc.nextInt();

        boolean prime = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false;
            }
        }
        System.out.println(prime);

    }
}
