package com.dsaproblems.varsha.binarySearch;

public class CapacityToShipPackagesWitinDDays {

    public static boolean canShip(int[] arr, int days, int capacity) {

        int currLoad = 0;
        int totalDays = 1;

        for (int weights : arr){

            if((weights + currLoad) <= capacity){ //weight + curr
                currLoad += weights;
            }
            else {
                totalDays ++;
                currLoad = weights;
                //we are not making it zero because this package will be the start of the next day if we make it zero the current package will be skipped
            }
        }

        return totalDays <= days;
    }

    public static int capacityToShip(int[] arr, int capacity) {

        int low = 0;
        int high = 0;

        for( int weights : arr){

            //the range of the capacity will be the maximum weight of the load because capacity below that will not work
            // the high will be the sum of all weights such all weights are loaded in one days

            low = Math.max(low, weights);
            high += weights;
        }

        while(low <= high){
            int mid = (low + high)/2;

            if(canShip(arr, capacity, mid)){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(capacityToShip(weights, D));
    }
}
