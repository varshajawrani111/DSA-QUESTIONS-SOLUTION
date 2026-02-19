package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import com.dsaproblems.varsha.arrays.CommonFunctionality;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    private static void meetingRoomSelection(int[] start, int[] end){

        int n = start.length;

        //Forming 2-D array with meeting start and end time in column 0 and column 1 respectively
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }

        //Sorting the meeting timing array according to finish time
        Arrays.sort(arr, Comparator.comparingInt(x -> x[1]));

        int j = 0;
        int count = 1; // we can perform atleast one activity

        for(int i = 1; i < n; i++){

            //Checking the start time of next meeting is greater than the finish time of last meeting
            if(arr[i][0] > arr[j][1]){

                count++; //if yes increasing the count

                j = i; //unpdating the last meeting to current one
            }

        }

        System.out.println(count);
    }

    public static void main(String[] args) {

        System.out.println("Enter the start time array: ");
        int[] start = CommonFunctionality.getInputArray();

        System.out.println("Enter the end time array: ");
        int[] end = CommonFunctionality.getInputArray();

        meetingRoomSelection(start, end);
    }
}
