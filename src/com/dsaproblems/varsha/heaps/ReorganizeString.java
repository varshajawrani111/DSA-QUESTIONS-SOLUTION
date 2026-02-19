package com.dsaproblems.varsha.heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static String reorganizeString(String str){

        //Hashmap to store the frequency of characters
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        //building max heap based on frequency value
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        Character prev = null;

        while(!pq.isEmpty()){
            Character curr = pq.poll();

            sb.append(curr);

            map.put(curr, map.get(curr)-1); //reducing the frequency of the current character

            if(prev != null && map.get(prev) > 0){
                pq.offer(prev);
            }

            prev = curr; //this will maintain the prev character
        }

        //if no possible combinations are possible
        if(sb.length() != str.length()){
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));   // aba
        System.out.println(reorganizeString("aaab"));  // ""
        System.out.println(reorganizeString("vvvlo")); // vovlv or similar
    }
}
