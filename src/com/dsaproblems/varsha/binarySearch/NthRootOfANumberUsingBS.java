package com.dsaproblems.varsha.binarySearch;

import java.util.Scanner;

public class NthRootOfANumberUsingBS {

    public static void main(String[] args) {

        System.out.println("Please enter a number");
        int num = new Scanner(System.in).nextInt();

        System.out.println("Please enter a Nth value");
        int n = new Scanner(System.in).nextInt();

        int low = 1;
        int high = num;

        int ans = -1;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(Math.pow(mid,n) == num){
                ans = mid;
                break;
            }

            if((long)Math.pow(mid,n) < num){

                low = mid+1; //may find root bigger tha this wil not update ans as we want perfect match only

            }else{

                high = mid-1; //need to search in smaller range

            }
        }

        System.out.println(ans);
    }
}
