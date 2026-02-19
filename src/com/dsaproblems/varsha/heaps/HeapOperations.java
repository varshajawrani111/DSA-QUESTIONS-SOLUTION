package com.dsaproblems.varsha.heaps;

import java.beans.PropertyEditorManager;
import java.util.ArrayList;

public class HeapOperations {

    //we are developing the min heap
    static ArrayList<Integer> list = new ArrayList<>();

    //function two swap two numbers
    public static void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    //method to return the parent of the given index
    //array is starting from index 0
    public static int parent(int i) {
        return (i - 1) / 2;
    }

    //method to return the left child index of a node
    public static int left(int i) {
        return (i * 2) + 1;
    }

    //method to return the right child index of a node
    public static int right(int i) {
        return (i * 2) + 2;
    }

    //Inserting the element in the min heap
    public static void insert(int value) {
        list.add(value); //adding the value at the end of the list
        upHeap(list.size() -1); //now comparing and swaping hte elements with parent if required
    }

    public static void upHeap(int i) {

        //if the index is root node
        if(i == 0) {
            return;
        }

        int parent = parent(i); //get the parent of the current node

        if(list.get(i) < list.get(parent) ) {
            swap(i, parent);
            upHeap(parent); //now move upwards with parent as current node
        }
    }

    //Deleting minimum element from min heap
    public static int delete(){
        if(list.isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        int value = list.getFirst();
        int last = list.removeLast(); //removing the last element from the list
        if(!list.isEmpty()) {
            list.set(0, last); //setting the last value as the root node
        }

        //moving downwards to swap the element if required to maintain the min heap property
        downHeap(0); //starting from root node

        return value;
    }

    public static void downHeap(int index) {



        //assuming the current index is having minimum element
        int min = index;
        //getting left and right children indexes
        int left = left(index);
        int right = right(index);

        //verifying if the minimum element is present at left
        if(left < list.size() && list.get(left) < list.get(min)) {
            min = left;
        }

        //verifying if the minimum element is present at right
        if(right < list.size() && list.get(right) < list.get(min)) {
            min = right;
        }

        if(min != index) {
            swap(min, index); //swaping the values
            downHeap(min); //moving downwards starting from minimum index
        }
    }

    //Heap Sort
    public static ArrayList<Integer> heapSort() {

        ArrayList<Integer> sortedList = new ArrayList<>();

        while(!list.isEmpty()) {
            sortedList.add(delete());
        }

        return sortedList;
    }

    public static void main(String[] args) {

        insert(34);
        insert(45);
        insert(22);
        insert(67);

        System.out.println(delete());
        System.out.println(heapSort());
    }
}
