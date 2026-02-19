package com.dsaproblems.varsha.backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public static boolean sudokuSolver(char[][] board, int row, int col) {

        //base case
        if(row == board.length) {
            return true;
        }

        //Calculating next row and next column
        int nextRow = row;
        int nextCol = col+1;

        //moving to next row
        if(nextCol == 9){
            nextCol = 0;
            nextRow++;
        }

        //to check if digit exits on that cell or not
        if(board[row][col] != '.'){
            return sudokuSolver(board, nextRow, nextCol);
        }

        //placing the digit
        for(char dig = '1'; dig <= '9'; dig++){
            if(isSafe(board, row, col, dig)){
                board[row][col] = dig;

                //calling for next cells
                if(sudokuSolver(board, nextRow, nextCol)){ //after finding one unique solution we will stop
                    return true;
                }

                //backtracking the digiti if it is wrongly placed
                board[row][col] = '.';
            }
        }

        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, char dig){

        //checking if the digit is present horizontally
        for(int j = 0; j < 9; j++){
            if(board[row][j] == dig){
                return false;
            }
        }

        //checking if hte digit is present vertically
        for(int i = 0; i < 9; i++){
            if(board[i][col] == dig){
                return false;
            }
        }

        //checking if the digit is present in the current grid
        //calculating the starting row and starting column of the grid
        int sRow = (row/3)*3;
        int sCol = (col/3)*3;

        for(int i = sRow; i <= sRow+2; i++){ //grid is always of size 2x2
            for(int j = sCol; j <= sCol+2; j++){
                if(board[i][j] == dig){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        sudokuSolver(sudoku,0,0);

        for (char[] chars : sudoku) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
