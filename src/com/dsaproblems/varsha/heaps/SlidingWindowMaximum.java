package com.dsaproblems.varsha.heaps;

import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 || k == 0)
            return new ArrayList<>(nums[0]);

        Deque<Integer> deque = new ArrayDeque<>(); //to store the indices of the elements in decreasing order
        int n = nums.length;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            //Remove the elements out of window
            if(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.pollFirst();
            }

            //Remove smaller elements(maintaining the decreasing order)
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i] ){
                deque.pollLast();
            }

            deque.offerLast(i); //add element at the back

            if(i >= k-1){
                res.add(nums[deque.peekFirst()]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(maxSlidingWindow(nums, k));
    }
}
