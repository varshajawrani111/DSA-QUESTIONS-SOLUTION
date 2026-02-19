package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumThree {

    private static void combinationsSum(List<Integer> curr, List<List<Integer>> result, int target, int index, int k) {

        //Only add when the required array size is equal to k
        if(curr.size() == k){

            //if combination is equal to a target add that in result
            if(target == 0){
                result.add(new ArrayList<>(curr));
                return;
            }

        }

        for(int i = index; i <= 9; i++){ //using elements from 1 to 9 only

            //No duplicate handling is needed as all elements are unique
            if(i > target){
                break;
            }

            curr.add(i); //add current element to the combination list
            combinationsSum(curr, result, target - i, i + 1, k); //recursively call the function by moving ahead and reducing target
            curr.remove(curr.size()-1); //remove the current element
        }
    }


    public static void main(String[] args) {

        System.out.println("Enter the target number:");
        int target = new Scanner(System.in).nextInt();

        System.out.println("Enter the value of k");
        int k = new Scanner(System.in).nextInt();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        combinationsSum(curr, result , target, 1, k);

        System.out.println(result);
    }
}
