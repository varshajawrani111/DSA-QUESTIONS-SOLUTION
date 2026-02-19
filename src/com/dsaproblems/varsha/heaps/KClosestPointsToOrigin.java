package com.dsaproblems.varsha.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int K) {

        // Max heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );
        /*
        * Distance formula:
                    distance=x2+y2
        */

        for (int[] point : points) {
            pq.offer(point);

            if (pq.size()>K){
                pq.poll(); //remove the farthest point
            }
        }

        int[][] ans = new int[K][2];
        int i = 0;

        while (!pq.isEmpty()){
            ans[i++]=pq.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2},{2,-2}};
        int k = 2;

        int[][] res = kClosest(points, k);
        for (int[] p : res) {
            System.out.println(Arrays.toString(p));
        }
    }
}
