package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.*;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        // Step 1: store last index of every character
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int maxLast = 0;    // farthest character's last occurrence
        int start = 0;      // start of current partition

        // Step 2: traverse and form partitions
        for (int i = 0; i < s.length(); i++) {
            maxLast = Math.max(maxLast, last[s.charAt(i) - 'a']);

            // When we reach the last occurrence of all characters seen so far
            if (i == maxLast) {
                result.add(i - start + 1);
                start = i + 1; // move start to next partition
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}

