package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class CountDigitsInNumber {

    private static int countDigits(int n) {

        //Base Case
        if(n==0)
            return 0;

        return 1+countDigits(n/10);
    }

    public static void main(String[] args) {

        System.out.println("Enter the value of N:");
        int n = new Scanner(System.in).nextInt();

        System.out.println(countDigits(n));
    }
}
