package com.dsaproblems.varsha.arrays;

public class MaximumNumberOfConsecutiveOnesInArray extends CommonFunctionality{

    public static void main(String[] args) {

        int[] arr = getInputArray();

        int max_streak = 0;
        int current_streak = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                current_streak++;
            }
            else{
                max_streak = Math.max(max_streak, current_streak);
                current_streak = 0;
            }
        }

        max_streak = Math.max(max_streak, current_streak); //to handle if array is ending with 1

        System.out.println("Maximum number of consecutive ones on array is: " + max_streak);
    }
}
