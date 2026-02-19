package com.dsaproblems.varsha.binarySearch;

public class MinimumNoOfDaysToMakeMBouquets {

    public static boolean canMakeBouquets(int[] arr, int days, int m, int k) {

        int count = 0;
        int noOfBouquets = 0;

        for(int num: arr){

            //the array element is less than or equal the blooming day increase counter
            if(num <= days){
                count++;
            }
            else {
                noOfBouquets += (count/k); //the non bloomed flower is encountered then we need to make counter zero
                //before that we will calculate the no of bouquets that can be formed
                count = 0;
            }
        }

        noOfBouquets += (count/k); //to get the last element counter also

        return noOfBouquets >= m;
    }

    public static int[] minMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return new int[]{min, max};
    }

    public static int minimumNoOfDaysToMakeBouquets(int[] arr, int m, int k) {

        //if array elements is less than no. of bouquets * no. of flowers
        if(arr.length < m * k){
            return -1;
        }

        //this will give us the range where we have to apply the binary search from the array elements
        int[] range = minMax(arr);
        int left = range[0];
        int right = range[1];

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(canMakeBouquets(arr, mid, m, k)){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = {7,7,7,7,13,11,12,7};
        int m = 2;
        int k = 3;

        System.out.println(minimumNoOfDaysToMakeBouquets(arr, m, k));
    }
}
