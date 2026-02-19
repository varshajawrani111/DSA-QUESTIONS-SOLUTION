package com.dsaproblems.varsha.backtracking;

import java.util.Scanner;

public class WordSearch {

    public static boolean wordSearch(char[][] board, String word){
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0) && exists(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean exists(char[][] board, String word, int row, int col, int index){

        //Base cases
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || board[row][col] != word.charAt(index) || board[row][col] == '#'){
            return false;
        }

        //Base case of word is found
        if(index == word.length()-1){
            return true;
        }

        //Marking cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        //Exploring all the directions of a cell for the next character
        boolean exists = exists(board, word, row + 1, col, index + 1) || //Down
                exists(board, word, row - 1, col, index + 1) || //Up
                exists(board, word, row , col + 1, index + 1) || //Right
                exists(board, word, row , col - 1, index + 1) ; //Left

        //Backtracking the cell value
        board[row][col] = temp;

        return exists;
    }

    public static void main(String[] args) {

        System.out.print("Enter the word: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.print(wordSearch(board, word));

    }
}
