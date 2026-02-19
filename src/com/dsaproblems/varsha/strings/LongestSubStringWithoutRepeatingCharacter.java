package com.dsaproblems.varsha.strings;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacter {

    public static int lengthOfLongestSubstring(String s, int k) {

        int left = 0;
        int right = 0;
        int ans = 0;

        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            char c = s.charAt(right);

            while(set.contains(c)){ //this skip the repeating character
                set.remove(c);
                left++;
            }

            set.add(c);

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb", 2));
    }
}
