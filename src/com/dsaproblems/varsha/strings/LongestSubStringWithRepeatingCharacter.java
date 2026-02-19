package com.dsaproblems.varsha.strings;

public class LongestSubStringWithRepeatingCharacter {

    public static int lengthOfLongestSubstring(String s, int k) {

        int[] occurrences = new int[26];
        int left = 0;
        int right = 0;
        int ans = 0;
        int maxOccurrences = 0;

        for(right = 0; right < s.length(); right++){

            maxOccurrences = Math.max(maxOccurrences, ++occurrences[s.charAt(right)-'a']);

            if((right-left+1)-maxOccurrences > k){
                occurrences[s.charAt(left)-'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb", 2));
    }
}
