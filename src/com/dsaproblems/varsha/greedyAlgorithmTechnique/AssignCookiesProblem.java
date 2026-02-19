package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class AssignCookiesProblem {

    private static int assignCookies(int[] greed, int[] cookies){

        //Sorting both greed and cookies array
        Arrays.sort(cookies);
        Arrays.sort(greed);

        //maintaining counters for both the arrays
        int i = 0;
        int j = 0;

        int count = 0;

        while (i < greed.length && j < cookies.length){

            //checking if the child greed isequl to no. of cookies at that point then increasing the count and both the points
            if (greed[i] <= cookies[j]){
                count++;
                i++;
                j++;
            }
            else{
                j++; //if not moving to next cookie
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println("Enter the greed array:");
        int[] greed = CommonFunctionality.getInputArray();

        System.out.println("Enter the cookies array:");
        int[] cookies = CommonFunctionality.getInputArray();

        int count = assignCookies(greed,cookies);

        System.out.println("Number of children assigned with cookies are: " + count);
    }
}
