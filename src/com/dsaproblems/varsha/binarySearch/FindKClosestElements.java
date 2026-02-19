package com.dsaproblems.varsha.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    //solving using the binary search and two pointers as array is sorted and output required should also be sorted
    public static List<Integer> findKClosestElements(int[] arr, int k, int x) {

        int n = arr.length;

        int left = 0;
        int right = n - 1;
        int pos = n; //by default

        //finding the position which is greater than equal to x
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] < x)
                left = mid + 1;

            else if(arr[mid] >= x){
                right = mid - 1;
                pos = mid;
            }
        }

        //two pointers
        int l = pos - 1;
        int r = pos;

        //pick elements
        while(k-- > 0){
            if(l<0){
                r++;
            } else if (r >= n) {
                l--;
            }else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        //get the result
        List<Integer> ans = new ArrayList<>();

        for(int i = l+1; i < r; i++){
            ans.add(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2, x = 3;

        System.out.println(findKClosestElements(arr, k, x));
    }
}
