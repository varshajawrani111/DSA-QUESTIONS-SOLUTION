package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

public class JumpGame1 {

    private static boolean jumpGame(int[] arr){

        int maxReach = 0;

        for(int i = 0; i < arr.length; i++){
            if(i > maxReach){ //we are stuck
                return false;
            }

            maxReach = Math.max(maxReach, i + arr[i]);

            if(maxReach >= arr.length - 1){ //can reach the end
                return true;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        System.out.println("Enter the jump array: ");
        int[] arr = CommonFunctionality.getInputArray();

        System.out.println(jumpGame(arr));
    }
}
