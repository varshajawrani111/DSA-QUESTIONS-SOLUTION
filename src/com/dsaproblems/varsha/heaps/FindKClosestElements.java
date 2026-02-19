package com.dsaproblems.varsha.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

    public static List<Integer> findKClosestElements(int[] arr, int k, int x) {

        //Solving using heap
        PriorityQueue<Integer> pq = new PriorityQueue<>( //creating max on the basis of distance
                (a,b)  -> {

                    //getting the absolute difference
                    int diff1 = Math.abs(a - x);
                    int diff2 = Math.abs(b - x);

                    if (diff1 != diff2)
                        return diff2 - diff1; // max heap by distance
                    return b - a; //if tie return the larger number first
                }

        );

        //maintaining the heap of size k
        for(int num : arr){
            pq.offer(num);

            if(pq.size() > k)
                pq.poll(); //remove the farthest element
        }

        List<Integer> res = new ArrayList<>(pq); //adding the remaining elements of heap in the list
        Collections.sort(res); //sorting the result

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2, x = 3;

        System.out.println(findKClosestElements(arr, k, x));
    }

}
