package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class CountTheNumberOfSetBits {
    public static void main(String[] args) {

        System.out.print("Enter the number: ");
        int num = new Scanner(System.in).nextInt();

        int count = getCount(num);

        System.out.println(count);
    }

    static int getCount(int num) {
        int count = 0;
        while(num != 0){
            num = num & (num -1);
            count++;
        }
        return count;
    }


}
