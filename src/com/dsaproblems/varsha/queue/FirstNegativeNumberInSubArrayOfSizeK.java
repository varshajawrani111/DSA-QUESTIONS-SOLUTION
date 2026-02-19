package com.dsaproblems.varsha.queue;

import java.util.*;

public class FirstNegativeNumberInSubArrayOfSizeK {

    public static List<Integer> firstNegativeNumberInSubArray(int[] arr, int k) {

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();

        //to store the indices of the negative elements
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){

            //Add negative elements indices to the queue
            if(arr[i] < 0){
                stack.offerLast(i);
            }

            //Remove elements outside window
            if(!stack.isEmpty() && stack.peekFirst() <= i-k){
                stack.pollFirst();
            }

            if(i >= k-1){
                ans.add(stack.isEmpty() ? 0 : arr[stack.peekFirst()]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        System.out.println(firstNegativeNumberInSubArray(arr, k));
    }
}
