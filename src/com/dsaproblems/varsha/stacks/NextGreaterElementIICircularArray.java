package com.dsaproblems.varsha.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementIICircularArray {

    public static List<Integer> nextGreaterElement(int[] nums){

        List<Integer> nge = new ArrayList<>(); //to store the next greater element of circular array
        Stack<Integer> st = new Stack<>(); //to maintain the monotonic stack

        int n  = nums.length;

        //will be running for loop from 2n - to 0 i. means traversing array twice
        for(int i = 2*n - 1 ; i >= 0; i--){

            int idx = i % n; //this will give the idx of array from original length

            //popping out the stack elements to maintain the monotonic stack
            while(!st.isEmpty() && st.peek() <= nums[idx]){
                st.pop();
            }

            //will push into the nge list only when we are in the original array length
            if(i < n){
                nge.add(st.isEmpty() ? -1 : st.peek());
            }

            st.push(nums[idx]);
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};

        List<Integer> result = nextGreaterElement(arr);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
