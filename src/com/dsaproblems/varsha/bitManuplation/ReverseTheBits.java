package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class ReverseTheBits {

    public static void main(String[] args) {

        System.out.println("Enter a number to reverse:");
        int n = new Scanner(System.in).nextInt();


        int result = 0;
        for(int i = 31; i >= 0; i--){

            result = (result << 1) | (n & 1);
            n = n >> 1;
        }

        System.out.println(result);
    }
}
