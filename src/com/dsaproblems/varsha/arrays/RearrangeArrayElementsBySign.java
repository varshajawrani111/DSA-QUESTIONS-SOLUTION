package com.dsaproblems.varsha.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign extends CommonFunctionality{

    public static void main(String[] args) {

        int[] arr = {7, 1, -5, -3, -6, 4};
        // we have to rearrange the elements in such a way that alternate elements are positive in sign

        List<Integer> positiveArray = new ArrayList<>();
        List<Integer> negativeArray = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                positiveArray.add(arr[i]); // maiantaining the positive elements arrat
            }else {
                negativeArray.add(arr[i]); // maiantaing the negative elements array
            }
        }

        int pos_idx=0;
        int neg_idx=0;
        int k = 0;

        while(pos_idx<positiveArray.size() && neg_idx<negativeArray.size()){
            arr[k++] = positiveArray.get(pos_idx++);
            arr[k++] = negativeArray.get(neg_idx++);

        }

        // this is to handle the case if any positive or negative elements are left
        while(pos_idx < positiveArray.size()){
            arr[k++] = positiveArray.get(pos_idx++);
        }
        while(neg_idx < negativeArray.size()){
            arr[k++] = negativeArray.get(neg_idx++);
        }


        System.out.println("Rearrange Array Elements by Sign");
        System.out.println(Arrays.toString(arr));

    }
}
