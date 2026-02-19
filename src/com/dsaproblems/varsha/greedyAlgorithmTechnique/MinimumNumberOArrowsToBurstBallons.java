package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.Arrays;

public class MinimumNumberOArrowsToBurstBallons {

    private static int minArrows(int[][] points){

        if(points.length == 0) return 0;

        //Sort the 2D array according to their end i.e second column
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; //minimum 1 arrow will be required
        int lastEnd = points[0][1]; //marking the lastEnd with first ballon end

        for (int i = 1; i < points.length; i++){ //points.length returns number of rows and point[i].length returns number of columns
            if(points[i][0] > lastEnd){
                lastEnd = points[i][1];
                arrows++;
            }
        }

        return arrows;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[][] points
                = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

        System.out.println(
                minArrows(points));
    }
}
