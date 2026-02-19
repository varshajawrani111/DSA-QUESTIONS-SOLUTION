package com.dsaproblems.varsha.arrays;

public class BuyAndSellStock extends CommonFunctionality{

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        int minprice = arr[0];
        int maxprofit = 0;

        //we have to get the maxprofit as a output
        for(int i=0;i<arr.length;i++){

            if(arr[i]<minprice){ // to get the minimum price first
                minprice=arr[i];
            }
            else if(arr[i]-minprice>maxprofit){ // to get the maximum profit buy comparing the difference
                maxprofit = arr[i]-minprice;
            }
        }

        System.out.println(maxprofit);
    }

}
