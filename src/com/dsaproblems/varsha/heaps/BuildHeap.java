package com.dsaproblems.varsha.heaps;

import java.util.Arrays;

public class BuildHeap {

    public static void buildMinHeap(int [] array){
        int n = array.length;

        for (int i=n/2-1;i>=0;i--){ //starting from first non-leaf node
            heapifyMinHeap(array,i);
        }
    }

    public static void buildMaxHeap(int [] array){
        int n = array.length;

        for (int i=n/2-1;i>=0;i--){ //starting from first non-leaf node
            heapifyMaxHeap(array,i);
        }
    }

    public static void heapifyMinHeap(int [] array,int i){

        int n = array.length;

        int min = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && array[left]<array[min]){
            min = left;
        }
        if(right<n && array[right]<array[min]){
            min = right;
        }

        if(min!=i){
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static void heapifyMaxHeap(int [] array,int i){

        int n = array.length;

        int max = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && array[left]>array[max]){
            max = left;
        }
        if(right<n && array[right]>array[max]){
            max = right;
        }

        if(max!=i){
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,4,7,8,9};
        buildMinHeap(arr);
        System.out.println(Arrays.toString(arr));

        buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
