package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class CheckIfithBitIsSet {
    public static void main(String[] args) {

        System.out.print("Enter a number to check if ith is set: ");
        int num = new Scanner(System.in).nextInt();

        System.out.print("Enter the index: ");
        int index = new Scanner(System.in).nextInt();

        if((num & (1 << index)) != 0){
            System.out.println("The ith bit is set");
        }
        else  System.out.println("The ith bit is not set");
    }
}
