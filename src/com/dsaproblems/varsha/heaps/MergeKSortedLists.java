package com.dsaproblems.varsha.heaps;

import java.util.*;

public class MergeKSortedLists {

    static class Node{
        int val;
        int listIndex;
        int elementIndex;

        Node(int val, int listIndex, int elementIndex) {
            this.val = val;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static List<Integer> mergeKLists(List<List<Integer>> lists) {

        //min heap to store lists elements
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        //store first elements of all the lit in the heap
        for(int i=0;i<lists.size();i++){
            int val = lists.get(i).getFirst();
            pq.offer(new Node(val,i,0));
        }

        List<Integer> res = new ArrayList<>();

        while(!pq.isEmpty()){

            Node curr = pq.poll();


            res.add(curr.val); //adding the smallest element in the list


            if(curr.elementIndex + 1 < lists.get(curr.listIndex).size()){
                int nextVal = lists.get(curr.listIndex).get(curr.elementIndex + 1); //getting the next element from the list from which the element is popped out
                pq.offer(new Node(nextVal,curr.listIndex,curr.elementIndex + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1,4,5));
        lists.add(Arrays.asList(1,3,4));
        lists.add(Arrays.asList(2,6));

        System.out.println(mergeKLists(lists));
    }
}
