package com.dsaproblems.varsha.binarySearch;

public class PaintersPartitionProblem {

    // Returns number of painters required if maxWork is allowed per painter
    public static int allocationOfBoards(int[] boards, int maxWork) {

        int currentWork = 0;
        int painters = 1;

        for (int board : boards) {

            if (currentWork + board <= maxWork) {
                currentWork += board;
            } else {
                painters++;
                currentWork = board;
            }
        }

        return painters;
    }

    public static int minimumTime(int[] boards, int painters) {

        int low = 0, high = 0;

        for (int board : boards) {
            low = Math.max(low, board); // at least one board
            high += board;              // one painter paints all
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int requiredPainters = allocationOfBoards(boards, mid);

            if (requiredPainters <= painters) {
                high = mid - 1;   // try smaller max time
            } else {
                low = mid + 1;    // need more time
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int k = 2;
        System.out.println(minimumTime(boards, k)); // 60
    }
}
