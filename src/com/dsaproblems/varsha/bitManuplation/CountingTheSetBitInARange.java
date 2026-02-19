package com.dsaproblems.varsha.bitManuplation;

import java.util.Scanner;

public class CountingTheSetBitInARange {

    //this method will return the largest power of 2 which is less than n
    public static int largestPowerOf2inRange(int n) {

        int x = 0;

        while((1 << x) <= n){
            x++;
        }

        return x-1;
    }

    //function to count the bits
    public static int getCount(int n){

        if(n == 0){
            return 0;
        }

        //largest power of 2 less than n
        int x = largestPowerOf2inRange(n);

        int bitsUpto2raisetoPowerx = x * (1 << (x-1)); //2^x-1 * x
        int msbfrom2raisetoPowerx = n - (1 << x) + 1; // n - 2^x + 1
        int rest = n - (1 << x); //n - 2^x

        return bitsUpto2raisetoPowerx + msbfrom2raisetoPowerx + getCount(rest);

    }

    public static void main(String[] args) {

        System.out.print("Enter the range: ");
        int range = new Scanner(System.in).nextInt();

        int count = getCount(range);

        System.out.print("The number of set bits in the range is: " + count);
    }
}
