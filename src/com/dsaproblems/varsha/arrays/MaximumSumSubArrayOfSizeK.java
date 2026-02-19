package com.dsaproblems.varsha.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSumSubArrayOfSizeK {

    public static int[] maxSumSubarray(int[] nums, int k) {

        int n = nums.length;

        int[] maxSum = new int[n-k+1];

        //it will be used for storing bith the indices and can be used to maintain a monotonic stack structure also
        Deque<Integer> dq = new ArrayDeque<>();

        //running a loop  from 0 to n-k
        for(int i=0;i<n;i++){

            // Remove elements outside window
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){ //this will contain the elements in window
                dq.pollFirst(); //poll from front
            }

            // Remove smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){ //this will create a monotonic stack
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store result when window is complete
            if (i >= k - 1) {
                maxSum[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] stock = maxSumSubarray(prices, k);

        System.out.println(Arrays.toString(stock));
    }
}
