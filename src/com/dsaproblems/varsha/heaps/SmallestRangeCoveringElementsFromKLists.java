package com.dsaproblems.varsha.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {

    static class Node{
        int value;
        int listIndex;
        int elementIndex;


        Node(int value,int listIndex,int elementIndex){
            this.value=value;
            this.listIndex=listIndex;
            this.elementIndex=elementIndex;
        }
    }

    public static int[] smallestRangeFromKLists(List<List<Integer>> nums ){

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value); //maintaining heap wrt to value

        int max = Integer.MIN_VALUE;

        //putting at least one element from all the lists
        for(int i=0;i<nums.size();i++){

            int val = nums.get(i).getFirst(); //adding first element from each list
            pq.offer(new Node(val,i,0));
            max=Math.max(max,val); //storing the maximum value
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        //process heaps
        while(pq.size() ==  nums.size()){

            Node curr = pq.poll();
            int min = curr.value; //getting the minimum element fromt he heap

            if(max - min < rangeEnd-rangeStart){
                rangeStart = min;
                rangeEnd = max;
            }

            //adding next element from the list which was having minimum element
            if(curr.elementIndex + 1 < nums.get(curr.listIndex).size()){

                int nextVal = nums.get(curr.listIndex).get(curr.elementIndex+1); //getting the next value from same list of min
                pq.offer(new Node(nextVal,curr.listIndex,curr.elementIndex+1));
                max=Math.max(max,nextVal); //update the max value
            }
            else {
                break; //if list is exhausted
            }
        }

        return new int[]{rangeStart,rangeEnd};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        System.out.println(Arrays.toString(smallestRangeFromKLists(nums)));
    }
}
