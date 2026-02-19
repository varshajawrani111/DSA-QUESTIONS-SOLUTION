package com.dsaproblems.varsha.heaps;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static int KthLargestElement(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //by default min heap will be implemented

        for (int num : nums) {
            pq.offer(num); //add elements in the queue
            if (pq.size() > k) {
                pq.poll(); //remove the smallest element as that will be on the top
            }
        }

        return pq.peek(); //kth largest
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(KthLargestElement(nums,k));
    }
}
