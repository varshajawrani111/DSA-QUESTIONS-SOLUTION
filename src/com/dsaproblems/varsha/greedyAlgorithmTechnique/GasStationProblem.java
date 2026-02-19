package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class GasStationProblem {

    private static int gasStationStart(int[] gas, int[] cost){

        int currTank = 0;
        int totalTank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){

            int diff = gas[i] - cost[i]; //how much fuel is left (or lost) after leaving this station.
            currTank += diff;
            totalTank += diff;

            if(currTank < 0){ //If the fuel becomes negative we cannot start from here
                currTank = 0;
                start = i+1;
            }
        }

        //Check if solution exists
        return totalTank >= 0 ? start : -1;
    }

    public static void main(String[] args) {

        System.out.println("Enter the gas station array: ");
        int[] gas = CommonFunctionality.getInputArray();

        System.out.println("Enter the cost array: ");
        int[] cost = CommonFunctionality.getInputArray();

        int start = gasStationStart(gas, cost);

        System.out.println("The starting index of gas station is: " + start);
    }
}
