package com.dsaproblems.varsha.binarySearch;

import java.util.Arrays;

public class AggressiveCows  {

    public static boolean canPlaceCows(int[] arr, int distance, int cows){

        int countCows = 1; //we can place at least one cow
        int lastPlaced = arr[0];

        for(int i = 1; i < arr.length; i++){

            if(arr[i] - lastPlaced >= distance){ //if the distance between the current stall and last placed cow stall os greater
                countCows++;
                lastPlaced = arr[i];
            }
        }

        return countCows >= cows;
    }

    public static int minimumOfMaximumDistanceOfCows(int[] arr, int cows){

        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length-1] - arr[0];
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canPlaceCows(arr, mid, cows)){
                ans = mid;
                low = mid + 1; //will search for more distance
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,8,4,9};
        int cows = 3;

        System.out.println(minimumOfMaximumDistanceOfCows(arr, cows));
    }
}
