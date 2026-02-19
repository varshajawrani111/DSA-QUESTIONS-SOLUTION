package com.dsaproblems.varsha.SortingAlgorithms;


import java.util.Arrays;
import java.util.Random;

public class QuickSort  extends SelectionSort {

    public static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {

        if(start >= end) {
            return;
        }

        int pivotIndex = new Random().nextInt(end-start+1)+start; //to randomly choose thepivot index
        int pivot = arr[pivotIndex];

        swap(arr,end,pivotIndex); // to put pivot as last element of the array

        int leftPointer = start;
        int rightPointer = end;

        while(leftPointer < rightPointer) {

            while(arr[leftPointer] <= pivot &&  leftPointer < rightPointer) {
                leftPointer++;
            }
            while(arr[rightPointer] >= pivot &&  leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr,leftPointer,rightPointer);
        }

        swap(arr,leftPointer,end); //to put pivot at correct position

        quickSort(arr,start,leftPointer-1);
        quickSort(arr,leftPointer+1,end);

    }


    public static void main(String[] args) {

        int[]  arr = getInputArray();

        quickSort(arr);

        System.out.println("Sorted array is:");
        System.out.print(Arrays.toString(arr));

    }
}
