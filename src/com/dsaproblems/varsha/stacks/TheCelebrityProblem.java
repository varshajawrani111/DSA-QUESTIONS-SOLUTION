package com.dsaproblems.varsha.stacks;

public class TheCelebrityProblem {

    public static int findingCelebrity(int[][] arr){

        int n =  arr.length;
        int top =0;
        int down = n-1;

        while(top<down){

            if(arr[top][down] == 1){ //if top knows bottom top cannot be celebrity
                top++;
            }
            else if(arr[down][top] == 1){ //if bottom knows top bottom cannot be celebrity
                down--;
            }

            else{
                top++;
                down--;
            }
        }


        //No celebrity
        if(top > down){
            return -1;
        }

        //checking if the top is celebrity or not
        for(int i = 0; i < n; i++){
            if(i == top){ //no need to check for the diagonals
                continue;
            }

            //verifying if the celebrity does not anyone and everyone knows celebrity if not true return -1
            if(arr[top][i] == 1 && arr[i][top] == 0){
                return -1;
            }
        }

        return top;
    }

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };

        System.out.println(findingCelebrity(M)); // 1
    }
}
