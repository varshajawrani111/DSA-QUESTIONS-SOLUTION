package com.dsaproblems.varsha.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumNumberOfMeetingsAttended {

    static class Meetings{
        int s;
        int e;

        Meetings(int start, int end){
            this.s = start;
            this.e = end;
        }
    }

    public static int maximumNumberOfMeetings(int[] start, int[] end) {

        int n = start.length;

        List<Meetings> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++){
            meetings.add(new Meetings(start[i], end[i]));
        }

        //sorting the meetings according to the start time
        meetings.sort((a, b) -> a.s - b.s);

        //min heap wrt to end time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for (Meetings m : meetings) {
            // If no meeting yet OR current meeting starts after last selected meeting ends
            if (pq.isEmpty() || m.s >= pq.peek()) {
                if (!pq.isEmpty()) pq.poll(); // remove the finished meeting
                pq.add(m.e);               // attend this meeting
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        System.out.println(maximumNumberOfMeetings(start, end));
    }
}
