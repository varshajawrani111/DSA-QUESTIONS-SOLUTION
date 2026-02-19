package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    private static void solution(int[][] maze, int row, int col, String path, List<String> result) {


        int n = maze.length;

        //Base case to check invalidity
        //Always remember first check the boundary case like row and col values then the maze value otherwise ArrayOutOfBound Exception will arise
        if(row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0 || maze[row][col] == -1){
            return;
        }

        //Base case to add path to result
        if(row == n-1 && col == n-1){
            result.add(path);
            return;
        }

        //marking the cell as visited
        maze[row][col] = -1;


        //Exploring all four directions of a cell no diagonal path is allowed
        solution(maze, row + 1, col, path + 'D', result); //Down
        solution(maze, row - 1, col, path + 'U', result); //Up
        solution(maze, row, col + 1, path + 'R', result); //Right
        solution(maze, row, col - 1, path + 'L', result); //left


        //Backtracking to restore original value of a cell
        maze[row][col] = 1;
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<String> result = new ArrayList<>();
        String path = "";

        solution(maze, 0 , 0 , path , result);

        System.out.println(result);
    }
}
