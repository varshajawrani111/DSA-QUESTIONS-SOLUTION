package com.dsaproblems.varsha.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKSmallestPairs {

    //custom class which will store the index of nums1 and nums2 array and sum of that pair in min heap
    static class Pair{
        int i;
        int j;
        int sum;

        Pair(int i,int j, int sum){
            this.i=i;
            this.j=j;
            this.sum=sum;
        }
    }

    public static List<List<Integer>> kClosest(int[] nums1, int[]nums2 , int k){

        List<List<Integer>> res = new ArrayList<>();

        //base conditions
        if(nums1.length==0 || nums2.length==0 || k<=0)
            return res;

        //creating min heap based on increasing order of the sum
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.sum - b.sum);

        //push first column pairs
        for(int i=0; i < Math.min(nums1.length,k) ;i++){
            pq.offer(new Pair(i,0,nums1[i]+nums2[0])); //pairing all elements of nums1 with 1st element of nums2
        }

        //extract k pairs from heap
        while(k-- > 0 &&!pq.isEmpty()){

            Pair curr = pq.poll();
            int i = curr.i;
            int j = curr.j;

            res.add(Arrays.asList(nums1[i],nums2[j]));

            //push net pair from same row
            if(j+1 < nums2.length){
                pq.offer(new Pair(i,j+1,nums1[i]+nums2[j+1]));
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;

        System.out.println(kClosest(nums1, nums2, k));
    }
}
