package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfCoinsRequired {

    private static int minCoins(int[] coins, int amount) {

        //Sort the coins array
        Arrays.sort(coins);

        int n = coins.length-1;
        int count = 0;

        for(int i = n; i>=0; i--){

            if(coins[i] <= amount){

                count += amount/coins[i]; //number of coins required
                amount = amount%coins[i]; //amount remaining
            }

            if(amount == 0){
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] coins = {1,2,5,10,20,50,100,200,500,2000};

        System.out.println("Enter the amount");
        int amount = new Scanner(System.in).nextInt();

        int minCoins = minCoins(coins,amount);

        System.out.println(minCoins);
    }
}
