package com.dsaproblems.varsha.heaps;

import java.util.PriorityQueue;

public class IPO {

    static class Project{
        int capital;
        int profit;

        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int[] profits, int[] capital, int k, int w) {

        //min heap to store projects in increasing order of their capital
        PriorityQueue<Project> minHeap = new PriorityQueue<>((a,b)->a.capital-b.capital);

        //max heap to store K projects in decreasing order of their profit
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((a,b)->b.profit-a.profit);

        //storing elements in the min heap based  on capital value
        for(int i = 0; i < profits.length; i++){
            minHeap.offer(new Project(capital[i], profits[i]));
        }

        //moving elements from min heap to max base don the capital value

        int currCapital = w;

        for(int i = 0; i < k; i++){

            while(!minHeap.isEmpty() && minHeap.peek().capital <= currCapital){
                maxHeap.offer(minHeap.poll()); //removing the project from minheap and adding in the max heap
            }

            //If no project can be done
            if(maxHeap.isEmpty()){
                break;
            }

            //we are choosing the best current available project and adding its profit in capital
            //so after k iteration we will be choosing k best projects
            Project best = maxHeap.poll();
            currCapital += best.profit;
        }

        return currCapital;
    }

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};

        System.out.println(findMaximizedCapital(profits, capital,k, w)); // 4
    }


}
