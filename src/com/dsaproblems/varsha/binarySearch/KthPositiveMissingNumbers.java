package com.dsaproblems.varsha.binarySearch;

public class KthPositiveMissingNumbers {

    public static int kthMissing(int[] arr, int k){

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = low + (high - low)/2;

            int missing = arr[mid] - (mid+1); //mid+1 gives the number of missing elements from 1 to N that should be there at that index

            if(missing <= k){
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return low+k; //or it will be high+1+k=> high+1 is the index where low will be pointing
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(kthMissing(arr, k));
    }
}
