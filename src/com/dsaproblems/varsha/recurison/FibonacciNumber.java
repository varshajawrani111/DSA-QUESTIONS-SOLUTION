package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class FibonacciNumber {

    private static int  fib(int n){

        //Base case
        if(n==0 ||n==1)
            return n;

        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Enter the value of N:");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Fibonacci of "+n+" is "+fib(n));
    }
}
