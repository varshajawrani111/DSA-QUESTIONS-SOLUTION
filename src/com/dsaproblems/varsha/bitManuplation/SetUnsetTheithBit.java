package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class SetUnsetTheithBit {

    public static void main(String[] args) {

        System.out.print("Enter the number: ");
        int num = new Scanner(System.in).nextInt();

        System.out.print("Enter the index: ");
        int index = new Scanner(System.in).nextInt();

        System.out.println("Number after setting the ith bit");
        System.out.println(num | (1 << index));

        System.out.println("Number after clearing the ith bit");
        System.out.println(num & (~(1 << index)));
    }
}
