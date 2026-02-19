package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class XOROfNumbersFrom1ToN {

    public static int XOROfNumbers(int n) {

        if(n % 4 == 1){
            return 1;
        }
        else if(n % 4 == 2){
            return n+1;
        }
        else if(n % 4 == 3){
            return 0;
        }
        else{
            return n;
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter the value of n :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(XOROfNumbers(n));
    }
}
