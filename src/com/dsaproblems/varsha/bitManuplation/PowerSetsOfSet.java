package com.dsaproblems.varsha.bitManuplation;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.ArrayList;
import java.util.List;

public class PowerSetsOfSet {

    public static List<List<Integer>> getPowerSets(int[] arr){

        int n = arr.length;

        //total no. of power sets
        int subSets = 1 << n;
        List<List<Integer>> subSetsList = new ArrayList<>();

        for(int mask = 0; mask < subSets; mask++){ //this bit will tell whether to include that element in list or not

            List<Integer> subSet = new ArrayList<>();

            for(int i = 0; i < n; i++){ //this

                if((mask & (1 << i)) != 0){ // check if i-th bit is set
                    subSet.add(arr[i]);
                }
            }

            subSetsList.add(subSet);
        }

        return  subSetsList;
    }

    public static void main(String[] args) {

        int[] set = CommonFunctionality.getInputArray();

        List<List<Integer>> powerSet = getPowerSets(set);

        System.out.println("The power set is:" + powerSet);
    }
}
