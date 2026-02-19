package com.dsaproblems.varsha.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementWithTwoArrays {

    public static int[] findNGE(int[] nums1, int[] nums2){

        int n = nums2.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //this will store the NGE of every element of Nums2


        Stack<Integer> st = new Stack<>(); //this monotonic stack to find the NGE of nums 2 array

        //all this to get the NGEof nums2 array and create a map for the result
        for(int i=n-1 ; i>=0; i--){

            // Remove all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // If stack empty → no greater element
            int nge = st.isEmpty()?-1:st.peek();
            map.put(nums2[i], nge);

            //push the current element in the stack
            st.push(nums2[i]);
        }

        //Build result for nums1
        int[] res = new int[nums1.length];
        for(int i =0 ; i<nums1.length; i++){
            res[i] = map.get(nums1[i]); //this will fetch the NGE of the element form the map as nums1 is the subset of nums2
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = findNGE(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}
