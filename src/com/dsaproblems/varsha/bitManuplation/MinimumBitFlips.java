package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class MinimumBitFlips {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = sc.nextInt();

        System.out.println("Enter the target number: ");
        int target=sc.nextInt();

        int ans = num ^ target;
        int count = 0;

        while(ans!=0){

            ans = ans & ans-1; //this will remove the rightmost set bit
            count++;
        }

        System.out.println(count);

    }
}
