package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.Arrays;

public class FractionalKnapsack {

    public static class Item{
        int weight;
        int value;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    private static double fractionalKnapsack(int capacity, Item[] items){

        //Sort the items array in descending order according to value/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(
                (double)b.value / b.weight,
                (double)a.value / a.weight
        ));

        double totalProfit = 0.0;

        for(Item item : items){

            if(capacity == 0){
                break;
            }

            if(item.weight <= capacity){
                totalProfit += item.value;
                capacity -= item.weight;
            }
            else{
                //Take fraction part
                double fractionalProfit = (double) capacity / item.weight;
                totalProfit += item.value * fractionalProfit;
                capacity = 0;  //bag becomes full
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {

        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50;

        double result = fractionalKnapsack(capacity, items);

        // Print result with 6 decimal places
        System.out.printf("Maximum value = %.6f", result);
    }
}

