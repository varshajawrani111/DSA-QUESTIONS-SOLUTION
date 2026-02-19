package com.dsaproblems.varsha.strings;

import java.util.Scanner;

public class RomanToInteger {

    public static int RomanToInteger(String s) {

        int total = 0;
        int prev = 0; // here previous is the right side value sp don't be confused

        for (int i = s.length() - 1; i >= 0; i--) {

            int curr = valueAt(s.charAt(i));
            if (curr >= prev) { //addition case
                total += curr;
            }else  {
               total -= curr; // subtraction case
            }

            prev = curr;
        }

        return total;
    }

    private static int valueAt(char c){
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Roman number: ");

        String str = sc.nextLine();

        System.out.print("Integer is :" + RomanToInteger(str));
    }
}
