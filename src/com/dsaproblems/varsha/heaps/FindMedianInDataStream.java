package com.dsaproblems.varsha.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianInDataStream {

    //Max heap for lower half
    private static PriorityQueue<Integer> maxHeap;
    //Min heap for upper half
    private static PriorityQueue<Integer> minHeap;

    FindMedianInDataStream() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }


    public  void addNum(int num) {

        //adding elements to heaps
        //All elements in maxHeap <= All elements in minHeap
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        //Balancing both the heaps
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public  double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0; //for even number of elements
        }

        //for odd number of elements the median will be in max heap
        return maxHeap.peek();  // maxHeap always has >= elements
    }

    public static void main(String[] args) {
        FindMedianInDataStream mf = new FindMedianInDataStream();
        mf.addNum(5);
        System.out.println(mf.findMedian()); // 5

        mf.addNum(15);
        System.out.println(mf.findMedian()); // 10

        mf.addNum(1);
        System.out.println(mf.findMedian()); // 5

        mf.addNum(3);
        System.out.println(mf.findMedian()); // 4
    }
}
