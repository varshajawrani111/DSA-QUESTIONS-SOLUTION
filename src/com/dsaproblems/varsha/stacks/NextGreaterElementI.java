package com.dsaproblems.varsha.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {

    //Input = [4,5,2,25]
    //Output = [5,25,25,-1]

    public static int[] findNGE(int[] arr){

        int n = arr.length;

        int[] res = new int[n]; //this will store the NGE for element at the given index
        Stack<Integer> st = new Stack<>(); //this monotonic stack to find the NGE

        for(int i=n-1 ; i>=0; i--){

            // Remove all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack empty → no greater element
            res[i] = st.isEmpty()?-1:st.peek();

            //push the current element in the stack
            st.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};

        int[] result = findNGE(arr);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
