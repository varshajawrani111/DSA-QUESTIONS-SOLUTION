package com.dsaproblems.varsha.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfMinAndMaxOfSubArrayOfSizeK {

    public static int minMaxSumOfSubArrayK(int[] arr, int k) {

        int n = arr.length;

        Deque<Integer> maxDeque = new ArrayDeque<>(); //to maintain monotonic decreasing stack
        Deque<Integer> minDeque = new ArrayDeque<>(); //to maintain monotonic increasing stack

        int sum = 0;

        for (int i = 0; i < n; i++) {

            //Remove elements outside window
            if(!maxDeque.isEmpty() && maxDeque.peekFirst() <= i-k){
                maxDeque.pollFirst();
            }

            //Remove smaller elements
            while(!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i]){
                maxDeque.pollLast();
            }

            //Remove elements outside window
            if(!minDeque.isEmpty() && minDeque.peekFirst() <= i-k){
                minDeque.pollFirst();
            }

            //Remove larger elements
            while(!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i]){
                minDeque.pollLast();
            }

            maxDeque.offerLast(i);
            minDeque.offerLast(i);

            if(i >= k-1){
                sum += arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{2,5,-1,7,-3,-1,-2};
        int k = 4;

        int sum = minMaxSumOfSubArrayK(prices, k);

        System.out.println(sum);
    }
}
