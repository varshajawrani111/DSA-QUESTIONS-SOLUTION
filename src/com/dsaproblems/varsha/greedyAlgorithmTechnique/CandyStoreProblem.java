package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;
import java.util.Scanner;

public class CandyStoreProblem {

    private static int[] candyStore(int[] prices, int k){

        //Sort the price array
        Arrays.sort(prices);

        int n = prices.length-1;

        //Minimum cost
        int s1 =0;
        int e1 = n;
        int minCost = 0;

        while (s1 <= e1){

            minCost = minCost + prices[s1]; //buy cheapest
            s1++; //move to next candy
            e1 -= k; //get expensive free
        }

        //Maximum cost
        int s2 = 0;
        int e2 = n;
        int maxCost = 0;

        while (s2 <= e2){
            maxCost = maxCost + prices[e2]; //buy expensive
            e2 --; //move to cheapest
            s2 += k; //get the cheapest free
        }

        return new int[]{minCost, maxCost};
    }

    public static void main(String[] args) {

        System.out.println("Enter the candy prices array: ");
        int[] prices = CommonFunctionality.getInputArray();

        System.out.println("Enter the value of free candies: ");
        int k = new Scanner(System.in).nextInt();

        int[] cost = candyStore(prices, k);

        System.out.println("Minimum Cost is: " + cost[0]);
        System.out.println("Maximum Cost is: " + cost[1]);
    }
}
