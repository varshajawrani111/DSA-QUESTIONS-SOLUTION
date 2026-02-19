package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationOfPhoneNumber {

    public static class Solution {
        private static final String[] MAP = {
                "",    //0
                "",    //1
                "abc", //2
                "def", //3
                "ghi", //4
                "jkl", //5
                "mno", //6
                "pqrs",//7
                "tuv", //8
                "wxyz" //9
        };

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.isEmpty()) return res;
            backtrack(res, new StringBuilder(), digits, 0);
            return res;
        }

    }

    private static void backtrack(List<String> res, StringBuilder current, String digits, int index){

        //Base case
        if(index == digits.length()){
            res.add(current.toString());
            return;
        }

        int d =  digits.charAt(index) - '0'; //converting the string digit to integer
        String letters = Solution.MAP[d]; //getting the letters at the d

        for(int i = 0; i < letters.length(); i++){
            current.append(letters.charAt(i)); //adding the letter to current combination
            backtrack(res, current, digits, index+1); //backtracking for the next digit letter
            current.deleteCharAt(current.length()-1); //removing the last letter from the current string
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Enter the phone number digits: ");
        String digits = new Scanner(System.in).nextLine();

        System.out.println(solution.letterCombinations(digits));

    }
}
