package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class ReverseNumberUsingRecursion {

    static int rev = 0; //global variable which will store the reverse number

    private static void reverse(int n)
    {
        if(n==0)
            return;

        rev = rev*10 + n%10;

        reverse(n/10);
    }

    public static void main(String[] args) {

        System.out.println("Enter the value of N:");
        int n = new Scanner(System.in).nextInt();

        reverse(n);

        System.out.println(rev);
    }
}
