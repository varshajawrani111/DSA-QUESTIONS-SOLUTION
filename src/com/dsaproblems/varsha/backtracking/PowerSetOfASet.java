package com.dsaproblems.varsha.backtracking;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.ArrayList;
import java.util.List;

public class PowerSetOfASet {

    private static void powerSet(int[] arr, List<Integer> temp, List<List<Integer>> result, int index) {

        result.add(new ArrayList<>(temp));

        for(int i= index;i<arr.length;i++){

            temp.add(arr[i]); //Include current element
            powerSet(arr,temp,result,i+1); //Explore other elements recusively
            temp.remove(temp.size()-1); //remove current element

        }
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        powerSet(arr,temp,result,0);

        System.out.println(result);

    }
}
