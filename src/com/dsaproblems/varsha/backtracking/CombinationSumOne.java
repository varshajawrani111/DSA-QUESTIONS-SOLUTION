package com.dsaproblems.varsha.backtracking;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumOne {

    private static void combinationsSum(int[] arr, List<Integer> curr, List<List<Integer>> result, int target, int index) {

        //if combination is equal to a target add that in result
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        //if combination doesn't satisfy the target remove that target
        if(index == arr.length || target < 0){
            return;
        }

        //this pick/not pick mehtod wroks when there are no duplicates in thearray otherwise we will use the general backtracking approach
        /*
        * in a for loop starting from the index:
        * add current elements
        * recursively call the function with next index and reduced target
        * remove the current element
        */

        curr.add(arr[index]); //add current element to the combination list
        combinationsSum(arr, curr, result, target - arr[index], index); //recursively call the function keeping index same and reducing target
        curr.remove(curr.size()-1); //remove the current element
        combinationsSum(arr, curr, result, target, index + 1);
        //recursively call the function by moving ahead, and we are not reducing the target because we are not adding that element
    }


    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();
        Arrays.sort(arr);

        System.out.println("Enter the target number:");
        int target = new Scanner(System.in).nextInt();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        combinationsSum(arr, curr, result , target, 0);

        System.out.println(result);
    }
}
