package com.dsaproblems.varsha.backtracking;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.ArrayList;
import java.util.List;

public class SubsetSums {

    private static void powerSetSum(int[] arr, List<Integer> temp, List<Integer> result, int index) {

        //include the sum of current set instead of whole set
        int sum = 0;
        for(int num : temp){
            sum += num;
        }
        result.add(sum);

        for(int i= index;i<arr.length;i++){

            temp.add(arr[i]); //Include current element
            powerSetSum(arr,temp,result,i+1); //Explore other elements recusively
            temp.remove(temp.size()-1); //remove current element

        }
    }

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        powerSetSum(arr,temp,result,0);

        System.out.println(result);

    }
}
