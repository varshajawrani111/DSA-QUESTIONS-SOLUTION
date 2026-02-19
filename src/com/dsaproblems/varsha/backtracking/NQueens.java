package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    public static boolean isSafe(char[][] board, int row, int col, int n) {

        //checking horizontally if Queen is placed in same row
        for (int i = 0; i < n; i++) {
            if(board[row][i] == 'Q')
                return false;
        }

        //checking vertically if Queen is placed in same row
        for (int i = 0; i < n; i++) {
            if(board[i][col] == 'Q')
                return false;
        }

        //checking in left diagonal upwards if queen is placed
        for (int i= row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        //checking in right diagonal upwards if queen is placed
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public static void nQueens(char[][] board, int row, int n, List<char[][]> result) {

        //Base case
        if (row == n) {

            char[][] copy = new char[n][n];
            /*Because board keeps changing during backtracking.
            If you add the same board reference to the result list, all stored solutions will eventually become empty or the same final state.
            */
            for (int i = 0; i < n; i++)
                copy[i] = board[i].clone();

            result.add(copy);
            return;

        }

        //placing the queen
        for (int i = 0; i < n; i++) {
            if(isSafe(board,row,i,n)){

                board[row][i] = 'Q';
                nQueens(board,row+1,n,result); //unlike sudoku where we stop after one solution we explore other solutions also
                board[row][i]='.';
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the value of N: ");
        int n = new Scanner(System.in).nextInt();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<char[][]> result = new ArrayList<>();

        nQueens(board,0, n , result);

        for (char[][] sol : result) {
            for (char[] row : sol) {
                for (char c : row)
                    System.out.print(c + " ");
                System.out.println();
            }
            System.out.println();
        }


    }

}
