package com.dsaproblems.varsha.binarySearch;

public class FindSmallestDivisorGivenThreshold {

    public static int sumOfArray(int[] arr, int div){

        double sum = 0;

        for(int num : arr){
            sum += Math.ceil((double) num/div);
        }

        return (int)sum;
    }

    public static int findSmallestDivisor(int[] arr, int threshold){

        int low = 1;
        int high = threshold;

        while(low <= high){
            int mid = (low + high)/2;

            int sum = sumOfArray(arr, mid);

            if(sum <= threshold){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int threshold = 6;
        System.out.println(findSmallestDivisor(arr, threshold));
    }
}
