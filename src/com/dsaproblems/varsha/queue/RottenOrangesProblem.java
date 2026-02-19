package com.dsaproblems.varsha.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesProblem {

    //to store this data structure in the queue with row and column with the rotten time
    static class Pair{
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    //method to check the boundary conditions
    static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public static int orangeRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        //visisted array
        int[][] visited = new int[row][col];

        //Adding rotten oranges in the queue
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else
                    visited[i][j] = 0;
            }
        }

        int time = 0;
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        while(!queue.isEmpty()){

            //getting the rotten oranges row and column and time value
            int r = queue.peek().row;
            int c = queue.peek().col;
            int tm = queue.peek().time;

            time = Math.max(tm, time);

            queue.poll(); //removing that orange from the queue

            //looping in all four directions
            for(int i = 0; i < 4; i++){

                //getting neighbouring cell row and column value
                int nr = r+directions[i][0];
                int nc = c+directions[i][1];

                //checking the boundary conditions, if it is not visited and it is the fresh orange
                if(isSafe(nr,nc,row,col) && visited[nr][nc] !=2 && grid[nr][nc] == 1){
                    queue.add(new Pair(nr,nc,tm + 1));
                    visited[nr][nc] = 2;
                }
            }
        }

        //checking if the orange is not rotten or not visited
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && visited[i][j] != 2){
                    return -1;
                }
            }
        }

        return time;
    }


    public static void main(String[] args) {

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println(orangeRotting(grid));
    }

}
