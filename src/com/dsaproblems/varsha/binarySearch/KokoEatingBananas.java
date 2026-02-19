package com.dsaproblems.varsha.binarySearch;

public class KokoEatingBananas {

    public static int totalHours(int[] arr, int k){

        double totalHours = 0;

        for (int j : arr) {

            totalHours += Math.ceil((double) j / k);
        }

        return (int) totalHours;
    }

    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        return max;
    }

    public static int minimumRateToEatBananas(int[] arr, int h){

        int low = 1;
        int high = max(arr);

        while (low <= high){

            int mid = low + (high - low)/2;

            int totalHours = totalHours(arr, mid);

            if(totalHours <= h){ //here if we find the rate to eat bananas we will search for more small value in left
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int h = 8;

        System.out.println(minimumRateToEatBananas(arr, h));
    }
}
