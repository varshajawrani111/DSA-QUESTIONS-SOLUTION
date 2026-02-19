package com.dsaproblems.varsha.arrays;

public class FindMissingNumberInArray extends CommonFunctionality{

    public static void main(String[] args) {

        int[] arr = getInputArray();


        //solving using the formula
        int n = arr.length; //to get the value of N as array is will be from 0 to N with N-1 elements
        // it will be arr.length + 1 if 1 to N range is there

        long expectedSum =(long) n*(n+1)/2; // formula to find the sum of first N natural numbers

        long actualSum = 0;

        for(int i = 0; i<arr.length;i++){
            actualSum += arr[i]; // difference of actual sum and expected sum will give the missing numbers
        }

        System.out.println("Missing Number from array is:" + (int)(expectedSum-actualSum));

        //solving using the xor operation

        int xor1 =0;
        int xor2 =0;

        for(int i = 0; i<arr.length;i++){ // to find the xor of array elements
            xor1 ^= arr[i];
        }

        for(int i = 0; i <= n;i++){ //to find the xor of 0 to n elements
            xor2 ^= i;
        }

        System.out.println("Missing Number from array is:" + (xor2^xor1));
    }
}
