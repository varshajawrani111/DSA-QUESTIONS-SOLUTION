package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;

public class CandyDistributionProblem {

    private static int candyDistribution(int[] ratings){

        int n =  ratings.length;
         int[] candies = new int[n];

         //Everyone gets 1 candy
        Arrays.fill(candies, 1);

        //Traversing from left to right
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        //Traversing from right to left
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1] + 1, candies[i]); //if already the child was having more candies
            }
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            total += candies[i];
        }

        return total;
    }

    public static void main(String[] args) {

         System.out.println("Enter the ratings array");
         int[] ratings = CommonFunctionality.getInputArray();

         int totalcandies = candyDistribution(ratings);
         System.out.println("Total candies distributed are: " + totalcandies);
    }
}
