package com.dsaproblems.varsha.binarySearch;


import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Scanner;

public class CountOccurencesInSortedArray extends FirstAndLastPositionOfElement{

    public static void main(String[] args) {

        int[] arr = CommonFunctionality.getInputArray();

        System.out.println("Enter the target elements");
        int target = new Scanner(System.in).nextInt();

        int firstIndex = findFirstOccurence(arr,target);
        int lastIndex = findLastOccurence(arr,target) ;

        if(firstIndex==-1){
            firstIndex = 0;
        }

        int occurences = lastIndex - firstIndex + 1;

        System.out.print(occurences);
    }
}
