package com.dsaproblems.varsha.arrays;

import java.util.Arrays;

public class MissinAndRepeatingNumber {

    public static int[] missinAndRepeatingNumber(int[] nums){

        int xor = 0;
        int n  = nums.length;

        //xoring all the array elements
        for (int num : nums) {
            xor ^= num;
        }

        //xoring all the elements from 1 to n
        for(int i = 1; i<= n ; i++){
            xor ^= i;
        }

        int setBit = xor ^ -xor;

        //separating the array elements into 2 bucket based on setbit
        int x = 0;
        int y = 0;

        for(int num : nums){
            if((num & setBit) != 0){
                x ^= num;
            }
            else
                y ^= num;
        }

        //separating the 1 to n elements into 2 bucket based on set bit
        for(int i = 1; i<= n ; i++){
            if((i & setBit) != 0){
                x ^= i;
            }
            else
                y ^= i;
        }

        //finding the missing and repeating number from array
        for(int num : nums){
            if(num==x){
                return new int[]{y,x}; //y is missing and x is repeating
            }
        }

        return new int[]{x,y};
    }


    //another approach for this problem will be using the mathematical equation
    //sum = n * (n+1) /2
    //squareSum = n * (n + 1) * (2 * n + 1) / 6

    public static int[] find(int[] arr) {
        int n = arr.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSqSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSqSum = 0;

        for (int num : arr) {
            actualSum += num;
            actualSqSum += (long) num * num;
        }

        long diff = actualSum - expectedSum; // R - M
        long sqDiff = actualSqSum - expectedSqSum; // R^2 - M^2

        long sumRM = sqDiff / diff; // R + M

        long repeating = (diff + sumRM) / 2;
        long missing = repeating - diff;

        return new int[]{(int) missing, (int) repeating};
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,5,4};
        System.out.println(Arrays.toString(missinAndRepeatingNumber(arr))); //xor method
        System.out.println(Arrays.toString(find(arr))); //mathematical equation
    }
}
