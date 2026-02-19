package com.dsaproblems.varsha.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParantheses {

    public static List<String> generateParentheses(int n){

        List<String> res = new ArrayList<>();

        if(n<=0) return res;

        generateParentheses(res,new StringBuilder(), n, n);
        return res;
    }

    // open = number of '(' remaining to place
    // close = number of ')' remaining to place
    public static void generateParentheses(List<String> res, StringBuilder current, int open, int close){

        //Base case
        if(open==0 && close==0){
            res.add(current.toString());
            return;
        }

        // place '(' if available
        if(open > 0){
            current.append('(');
            generateParentheses(res, current, open-1, close);
            current.deleteCharAt(current.length()-1);
        }

        // place ')' only if there are more ')' left than '(' (i.e., there are unmatched '(' )
        if(close > open){
            current.append(')');
            generateParentheses(res, current, open, close-1);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter number:");
        int n = new Scanner(System.in).nextInt();

        System.out.println(generateParentheses(n));
    }
}
