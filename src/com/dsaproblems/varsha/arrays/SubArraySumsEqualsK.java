package com.dsaproblems.varsha.arrays;

import java.util.HashMap;

public class SubArraySumsEqualsK {

    public static int subArraySumsEqualsK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //very important

        int sum = 0;
        int count = 0;

        for(int num : arr){
            sum += num;//adding current element in the sum

            if(map.containsKey(sum-k)){
                count += map.get(sum-k); //this will store the frequency how many times this sum is seen i.e subarrays with sum as target
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            //If sum exists in the map → return its value
            //If sum does NOT exist → return 0

        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2;
        System.out.println(subArraySumsEqualsK(arr, k));
    }
}
