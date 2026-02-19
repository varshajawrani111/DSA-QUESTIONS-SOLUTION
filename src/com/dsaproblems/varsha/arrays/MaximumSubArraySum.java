package com.dsaproblems.varsha.arrays;

public class MaximumSubArraySum extends CommonFunctionality{

    public static void main(String[] args) {

        int[] arr = {-2, -3, -4};

        int current_sum = arr[0];
        int max_sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current_sum = Math.max(current_sum + arr[i], arr[i]); // to keep record of maximum sum in a sequence
            max_sum = Math.max(max_sum, current_sum); //to keep record of maximum sum
        }

        System.out.println(max_sum);
    }
}
