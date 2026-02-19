package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class DivideTwoIntegers {

    public static long func(long dividend, long divisor) {

        if(dividend == divisor){
            return 1;
        }

        boolean sign = dividend < 0 == divisor < 0;


        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        long ans = 0;

        while(n >= d){

            long count = 0;

            while(n >= (d<<(count+1))){
                count++;
            }


            ans += (1L << count);
            n = n - (d * (1L <<count));
        }

        if (ans >= Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign ? ans : -ans;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dividend: ");
        long dividend = sc.nextLong();

        System.out.println("Enter the divisor: ");
        long divisor = sc.nextLong();

        System.out.println(func(dividend, divisor));

    }
}
