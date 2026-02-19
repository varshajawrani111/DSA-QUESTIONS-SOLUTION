package com.dsaproblems.varsha.stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {

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

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangle(heights)); // 10
    }
}
