package com.dsaproblems.varsha.basicMaths;

import java.util.Scanner;

public class CountDigitsInNumber {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number:");
        int n=sc.nextInt();

        int digits=0;

        while(n!=0){

            n=n/10;
            digits++;

        }

        System.out.println(digits);
    }
}
