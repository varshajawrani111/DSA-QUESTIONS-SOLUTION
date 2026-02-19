package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class CheckIfNumberIsPowerOf2 {

    public static void main(String[] args) {

        System.out.println("Enter a number");
        int num = new Scanner(System.in).nextInt();

        if((num & num-1) == 0){ //power of 2 number always have only one bit set
            System.out.println("The number is a power of 2");
        }
        else {
            System.out.println("The number is not a power of 2");
        }
    }
}
