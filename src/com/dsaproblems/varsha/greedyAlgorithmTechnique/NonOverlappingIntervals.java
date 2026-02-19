package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.Arrays;

public class NonOverlappingIntervals {

    private static int minRemoval(int[][] intervals){

        if (intervals.length == 0) return 0;

        //Sort the intervals in ascending order according to their end time
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < prevEnd){ //overlap -> removal interval
                count++;
            }
            prevEnd = intervals[i][1]; //update previous end with current end
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals));
    }
}
