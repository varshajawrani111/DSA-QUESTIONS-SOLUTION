package com.dsaproblems.varsha.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

    public static int[] nextSmallerElement(int[] arr){

        int n = arr.length;

        int[] nse = new int[n]; //to store next smaller element
        Stack<Integer> st = new Stack<>(); //to store monotonic increasing elements

        for(int i = n-1; i>=0; i--){

            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }

            nse[i] = st.isEmpty()?-1:st.peek();

            st.push(arr[i]);
        }

        return nse;
    }

    public static void main(String[] args) {
        int[] arr = {4,8,5,2,25};

        int[] result = nextSmallerElement(arr);

        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
