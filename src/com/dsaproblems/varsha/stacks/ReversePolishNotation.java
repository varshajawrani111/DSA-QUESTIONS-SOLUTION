package com.dsaproblems.varsha.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {

    public static int reversePolishNotation(String[] tokens){

        Deque<Integer> stack = new ArrayDeque<>();

        for(String token : tokens){

            //If operator
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){

                int a = stack.pop();
                int b = stack.pop();

                switch(token){
                    case "+": stack.push(a+b);
                    break;
                    case "-": stack.push(a-b);
                    break;
                    case "*": stack.push(a*b);
                    break;
                    case "/": stack.push(a/b);
                    break;
                }
            }
            //if operand
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2","1","+","3","*"};
        System.out.println(reversePolishNotation(tokens)); // 9
    }
}
