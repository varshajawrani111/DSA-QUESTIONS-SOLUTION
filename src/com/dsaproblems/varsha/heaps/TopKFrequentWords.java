package com.dsaproblems.varsha.heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public static List<String> topKFrequentWords(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>(); //hasp map to store the frequency of words
        for (String word : words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a); // higher freq first
            }
            return a.compareTo(b); // lexicographically smaller first
        });
        /*
        * What does compareTo() mean for Strings?

        compareTo() compares two strings lexicographically (alphabetical order).
        It returns:
        negative number → if a comes before b
        0 → if both are equal
        positive number → if a comes after b
    */
        pq.addAll(map.keySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "coding","i","love"};
        int k = 2;

        System.out.println(topKFrequentWords(words, k));
    }
}
