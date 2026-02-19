package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class MinimumNumberOfPlatformsRequired {

    private static int minimumPlatformRequired(int[] arrival, int[] departure) {

        //Sortiign both the arriavl and departure array
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int n = arrival.length-1;

        int count = 1;
        int result = 1;
        int i=0;
        int j=0;

        while(i<n && j<n){
            if(j<n && arrival[i]<=departure[j]){ //checking if the arrival time of next train is less than departure of current train so increase the count

                count++;
                i++;

            }else {
                count--; // the train has left so decrease the count of platform
                j++;
            }

            result = Math.max(count,result);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Enter the arrival array ");
        int[] arrival = CommonFunctionality.getInputArray();

        System.out.println("Enter the departure array ");
        int[] departure = CommonFunctionality.getInputArray();

        int platforms = minimumPlatformRequired(arrival, departure);

        System.out.println(platforms);
    }
}
