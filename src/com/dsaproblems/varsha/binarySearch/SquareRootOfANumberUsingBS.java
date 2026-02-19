package com.dsaproblems.varsha.binarySearch;

import java.util.Scanner;

public class SquareRootOfANumberUsingBS {

    public static void main(String[] args) {

        System.out.println("Please enter a number");
        int num = new Scanner(System.in).nextInt();

        int low = 1;
        int high = num;

        int sqrt = -1;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(mid*mid == num){
                sqrt = mid;
                break;
            }

            if((long)mid*mid < num){
                low = mid+1; //may find root bigger tha this
                sqrt = mid; //possible square root
            }else{

                high = mid-1; //need to search in smaller range

            }
        }

        System.out.println(sqrt);
    }
}
