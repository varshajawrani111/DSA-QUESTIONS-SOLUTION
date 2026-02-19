package com.dsaproblems.varsha.backtracking;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSumTwo {

    private static void combinationsSum(int[] arr, List<Integer> curr, List<List<Integer>> result, int target, int index) {

        //if combination is equal to a target add that in result
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(index >= arr.length ){
            return;
        }

        for(int i = index; i < arr.length; i++){

            if(i > index && arr[i] == arr[i-1]){ //skipping the duplicate
                continue;
            }

            if(arr[i] > target){  //we can check this in this way also target < 0 before the loop
                break;
            }

            curr.add(arr[i]); //add current element to the combination list
            combinationsSum(arr, curr, result, target - arr[i], i + 1); //recursively call the function by moving ahead and reducing target
            curr.remove(curr.size()-1); //remove the current element
        }
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
