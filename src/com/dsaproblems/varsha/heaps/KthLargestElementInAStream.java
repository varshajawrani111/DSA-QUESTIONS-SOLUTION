package com.dsaproblems.varsha.heaps;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    private static PriorityQueue<Integer> pq;
    private static int k;

    KthLargestElementInAStream(int k) {
        KthLargestElementInAStream.k = k;
        pq = new PriorityQueue<>();
    }

    public void add(int val){
        pq.add(val);
        
        if(pq.size() > k){
            pq.poll(); //remove the smallest element 
        }
    }
    
    public Object getKthLargest(){
        if(pq.size() < k){
            return null;
        }
        
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream kth = new KthLargestElementInAStream(3);

        kth.add(4);
        kth.add(5);
        kth.add(8);
        kth.add(2);

        System.out.println(kth.getKthLargest()); // 4
    }
    
}
