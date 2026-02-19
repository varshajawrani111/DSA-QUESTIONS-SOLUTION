package com.dsaproblems.varsha.basicMaths;

import java.util.Scanner;

public class EuclieanAlgorithm {

    //Euclidean algorithm is the effective approach to find the GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int a = sc.nextInt();
        System.out.println("Enter the second number: ");
        int b = sc.nextInt();

        System.out.println(gcd(a, b));
    }
}
