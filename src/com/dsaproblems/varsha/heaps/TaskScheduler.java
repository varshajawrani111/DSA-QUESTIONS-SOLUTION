package com.dsaproblems.varsha.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        //Hashmap tostore the frequency of the tasks
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //MAx heap to spread out the most frequent tasks first
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        int time  = 0;


        while(!pq.isEmpty()){

            int cycle = n+1;
            List<Character> temp = new ArrayList<>();

            while(cycle > 0 && !pq.isEmpty()){
                char c = pq.poll();
                time++;

                map.put(c,map.get(c)-1);

                if(map.get(c) > 0){
                    temp.add(c);
                }

                cycle--;
            }

            //push back the temp characters after the cooldown period is done
            pq.addAll(temp);

            //add idle time if required
            if(!pq.isEmpty()){
                time += cycle;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks, 2)); // 8
    }
}
