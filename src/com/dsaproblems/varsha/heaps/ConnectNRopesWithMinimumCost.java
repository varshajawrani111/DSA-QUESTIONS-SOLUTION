package com.dsaproblems.varsha.heaps;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {

    public static int connectNRopesWithMinimumCost(int[] points){

        //min heap to store the ropes and if connected their sum
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int r : points){
            pq.offer(r); //add ropes in the heap
        }

        int totalCost  = 0;
        while(pq.size()>1){

            int first = pq.poll(); //1st smallest rope
            int second = pq.poll(); //second smallest rope

            int sum = first+second;
            totalCost += sum;

            pq.offer(sum); //add the sum back to the heap for further connections
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] points = {4,3,2,6};
        System.out.println(connectNRopesWithMinimumCost(points));
    }
}
