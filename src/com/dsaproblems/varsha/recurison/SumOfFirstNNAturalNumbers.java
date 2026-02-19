package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class SumOfFirstNNAturalNumbers {

    private static int sum(int n){


        //Base case
        if(n==0)
            return 0;

        return n+sum(n-1);
    }

    public static void main(String[] args) {

        System.out.print("Enter the value of N: ");
        int n = new Scanner(System.in).nextInt();

        System.out.println(sum(n));
    }
}
