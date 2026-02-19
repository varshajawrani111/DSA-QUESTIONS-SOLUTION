package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class FactorialOfN {

    private static int factorial(int n){

        //Base case
        if(n==0)
            return 1;

        return n * factorial(n-1);
    }

    public static void main(String[] args) {

        System.out.println("Enter the value of N:");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Factorial of "+n+" is "+factorial(n));

    }
}
