package com.dsaproblems.varsha.graphs;

import java.util.*;

public class AlienDictionary {

    public static String alienOrder(String[] words) {

        //To store the graph character and its neighbour
        Map<Character, List<Character>> graphMap = new HashMap<>();
        //Indegree map
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graphMap.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        //Build Edges-Important Step to build graph
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int len = Math.min(word1.length(), word2.length());
            for(int j = 0; j < len; j++){
                if(word1.charAt(j) != word2.charAt(j)){

                    char u = word1.charAt(j);
                    char v = word2.charAt(j);

                    graphMap.get(u).add(v);
                    inDegree.put(v, inDegree.get(v) + 1);
                    break;
                }
            }
        }

        StringBuilder result = topologicalSort(inDegree, graphMap);


        if (result.length() != inDegree.size())
            return "";

        return result.toString();
    }

    private static StringBuilder topologicalSort(Map<Character, Integer> inDegree, Map<Character, List<Character>> graphMap) {
        //Topological Sorting
        Queue<Character> queue = new LinkedList<>();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0)
                queue.add(c);
        }

        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()){
            Character c = queue.poll();
            result.append(c);

            for (Character ch : graphMap.get(c)) {
                inDegree.put(ch, inDegree.get(ch) - 1);

                if(inDegree.get(ch) == 0){
                    queue.add(ch);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }
}
