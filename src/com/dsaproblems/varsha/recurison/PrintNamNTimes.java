package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class PrintNamNTimes {

    private static void print(int n){

        //Base case
        if(n == 0)
            return;

        System.out.println("Name");
        print(n-1);

    }

    public static void main(String[] args) {

        System.out.println("Enter the value of N");
        int n = new Scanner(System.in).nextInt();

        print(n);

    }
}
