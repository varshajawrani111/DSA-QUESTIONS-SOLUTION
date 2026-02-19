package com.dsaproblems.varsha.arrays;

import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence extends CommonFunctionality{

    public static void main(String[] args) {

        int[] arr = getInputArray();


        //Creating the hash set for the array elements to remove duplicates
        Set<Integer> set = new HashSet<Integer>();
        for(int i : arr){
            set.add(i);
        }

        int streak = 1;
         for(int i : set){

             //to find the the start of the streak by checking of the previous number of that doesn't exist
             if(!set.contains(i-1)){

                 int current = i;
                 int count = 1;

                 while(set.contains(current+1)){ //continuing the loop to find longest consecutive nummbers in the set
                     current++;
                     count++;
                 }

                 streak = Math.max(streak,count);
             }
         }

         System.out.println(streak);

    }
}
