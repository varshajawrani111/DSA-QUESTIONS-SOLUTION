package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class MinimumTimeToMakeRopeColourful {

    private static int minTime(String colors, int[] neededTime){

        int totalTimeForDeletion = 0;

        for(int i = 1; i < colors.length(); i++){

            //checking if the next character is same
            if(colors.charAt(i) == colors.charAt(i-1)){
                totalTimeForDeletion += Math.min(neededTime[i], neededTime[i-1]); //adding minimum time between both as deletion time

                // Keep the larger time as the "current" balloon
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTimeForDeletion;
    }

    public static void main(String[] args) {

        System.out.println("Enter the colors string: ");
        String colorsString = new Scanner(System.in).next();

        System.out.println("Enter the needed time array");
        int[] neededTime = CommonFunctionality.getInputArray();

        System.out.println(minTime(colorsString,neededTime));
    }

}
