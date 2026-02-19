package com.dsaproblems.varsha.stacks;

import java.util.Stack;

public class MaximalBinaryMatrixInBinaryMatrix {

    public static int largestRectangle(int[] heights) {

        Stack<Integer> stack = new Stack<>(); // Stack stores indices of bars in increasing height order

        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // While current bar is smaller than stack top,
            // we found the Next Smaller Element (NSE)
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                int elementIdx = stack.pop();   // index of bar
                int nse = i;                    // next smaller element index
                int pse = stack.isEmpty() ? -1 : stack.peek(); // previous smaller index

                int width = nse - pse - 1;
                int area = heights[elementIdx] * width;

                maxArea = Math.max(maxArea, area);
            }

            // Push current index
            stack.push(i);
        }

        // Process remaining bars in stack
        while (!stack.isEmpty()) {

            int elementIdx = stack.pop();
            int nse = n;  // no smaller element on right
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int width = nse - pse - 1;
            int area = heights[elementIdx] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int maximalRectangle(int[][] matrix){

        int n = matrix.length;
        int m  = matrix[0].length;

        int maxArea = 0;
        int[] height = new int[m]; // heights will store histogram heights

        for (int[] ints : matrix) {
            for (int j = 0; j < m; j++) {

                if (ints[j] == 1) {
                    height[j]++; //if 1 is encountered it will increase the height of that bar
                } else {
                    height[j] = 0; //if 0 is encountered the bar height will reset ot 0
                }
            }

            maxArea = Math.max(maxArea, largestRectangle(height));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        System.out.println(maximalRectangle(mat));
    }
}
