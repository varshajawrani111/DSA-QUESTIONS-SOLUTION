package com.dsaproblems.varsha.heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {

    public static int kthSmallest(int[] arr,int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //this will implement max heap

        for (int num : arr) {
            pq.offer(num);
            if (pq.size()>k){
                pq.poll(); //removes the largest element
            }
        }

        return pq.peek(); //kth smallest
    }

    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(kthSmallest(arr,k));
    }
}
