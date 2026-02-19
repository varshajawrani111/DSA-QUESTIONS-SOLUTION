package com.dsaproblems.varsha.stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static int[] stockSpan(int[] prices){

        int n = prices.length;

        int[] span = new int[n]; //to store the stock span of each stock prices
        Stack<Integer> st = new Stack<>(); //to store the index of previous greater element

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && prices[st.peek()] <= prices[i]){ //creating monotonic decreasing stack of the array index
                st.pop();
            }

            span[i] = st.isEmpty() ? i+1 : i - st.peek();

            st.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{100,80,60,70,60,75,85};

        int[] stock = stockSpan(prices);

        System.out.println(Arrays.toString(stock));
    }
}
