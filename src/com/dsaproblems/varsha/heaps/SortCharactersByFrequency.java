package com.dsaproblems.varsha.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static String sortCharactersByFrequency(String words) {

        HashMap<Character, Integer> map = new HashMap<>(); //hash map to store the frequency of characters

        for(char c : words.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a)); //to build max heap wrt frequency
        StringBuilder sb = new StringBuilder();

        pq.addAll(map.keySet()); //adding all the characters in the queue

        while(!pq.isEmpty()){
            char c = pq.poll(); //getting the top character
            int freq = map.get(c); //getting its frequency from map

            for(int i=0;i<freq;i++){
                sb.append(c);//appending hte characters according to the count
            }
            //sb.append(String.valueOf(c).repeat(Math.max(0, freq)));--> can be written like this
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortCharactersByFrequency("tree"));   // eert or eetr
        System.out.println(sortCharactersByFrequency("cccaaa")); // cccaaa or aaaccc
    }
}
