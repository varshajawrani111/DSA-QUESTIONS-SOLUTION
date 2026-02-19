package com.dsaproblems.varsha.arrays;

import java.util.*;

public class LeaderInAnArray extends CommonFunctionality{
    public static void main(String[] args) {

        int[] arr = getInputArray();

        int n = arr.length;
        int currentMax= arr[n-1];

        List<Integer> res = new ArrayList<Integer>();

        for(int i=n-1; i >=0; i--){
            if(arr[i] >= currentMax){
                currentMax=arr[i];
                res.add(arr[i]);
            }
        }

        Collections.reverse(res);

        System.out.println("Leaders in an array are " + res.toString());
    }
}
