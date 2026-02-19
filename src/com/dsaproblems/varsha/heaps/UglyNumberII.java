package com.dsaproblems.varsha.heaps;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {

    //An ugly number is a number whose only prime factors are 2, 3, and 5.
    public static int getNthUglyNumber(int n){

        //Min heap to get the smallest ugly number
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L); //adding o1 as it is the smallest upgly number

        HashSet<Long> seen = new HashSet<>(); //to maintain the seen elements toavoid duplicates in the heap
        seen.add(1L); //adding 1 in the set

        long curr = 1L;

        for(int i = 0; i < n; i++){

            curr = pq.poll(); //popping the smallest ugly number

            long next2 = curr * 2;
            long next3 = curr * 3;
            long next5 = curr * 5;

            if(!seen.contains(next2)){
                pq.offer(next2);
                seen.add(next2);
            }

            if(!seen.contains(next3)){
                pq.offer(next3);
                seen.add(next3);
            }

            if(!seen.contains(next5)){
                pq.offer(next5);
                seen.add(next5);
            }
        }

        return (int)curr;
    }

    public static void main(String[] args) {
        System.out.println(getNthUglyNumber(10));
    }
}
