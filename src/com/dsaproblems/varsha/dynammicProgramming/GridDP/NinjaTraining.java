package com.dsaproblems.varsha.dynammicProgramming;

public class NinjaTraining {

    public static int maximumPoints(int[][] points, int[][] dp, int n) {

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        //For days 1 to N
        for(int day = 1; day < n; day++){
            //for last activity 0 to 4 as dp[n][4]
            for(int last = 0; last < 4; last++){

                dp[day][last] = 0;
                //for activity 0 to 3
                for (int task = 0; task < 3; task++){

                    if(task != last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(point, dp[day][last]);
                    }
                }
            }
        }

        return dp[n-1][3];

    }

    public static int maximumPointsSpaceOptimized(int[][] points, int[] prev, int n) {

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        //For days 1 to N
        for(int day = 1; day < n; day++){

            int[] temp = new int[4];
            //for last activity 0 to 4 as dp[n][4]
            for(int last = 0; last < 4; last++){

                temp[last] = 0;

                //for activity 0 to 3
                for (int task = 0; task < 3; task++){

                    if(task != last){
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(point, temp[last]);
                    }
                }

            }

            prev = temp;
        }

        return prev[3];

    }

    public static void main(String[] args) {
        int[][] points = {{10,40,70}, {20,50,80}, {30,60,90}};
        int n = points.length;

        int[] prev = new int[4];
        int[][] dp = new int[n][4];

        System.out.println(maximumPoints(points, dp, n));
        System.out.println(maximumPointsSpaceOptimized(points, prev ,n));
    }
}
