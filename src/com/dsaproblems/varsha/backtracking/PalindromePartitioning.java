package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {

    public static List<List<String>> palindromePartitioning(int start, List<List<String>> res,List<String> current ,String s) {

        if(start == s.length()){
            res.add(new ArrayList<>(current));
            return res;
        }

        for(int i = start; i < s.length(); i++){

            if(isPalindrome(s,start,i)) { //checking of string is palindrome

                current.add(s.substring(start, i + 1)); //adding the substring to current
                palindromePartitioning(i + 1, res, current, s); //backtracking by moving start index ahead
                current.removeLast(); //removing last string from current

            }

        }

        return res;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the string");
        String str = sc.nextLine();

        List<List<String>> res = new ArrayList<>();
        System.out.println(palindromePartitioning(0,res,new ArrayList<>(),str));
    }
}
