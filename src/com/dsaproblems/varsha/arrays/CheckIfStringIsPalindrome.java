package com.dsaproblems.varsha.arrays;

import java.util.Scanner;

public class CheckIfStringIsPalindrome {

    static boolean isPalindrome = true;

    private static void isPalindrome(String str, int i) {

        //Base Condition;
        if(str.length()==0 || i==str.length())
            return;
        else if (str.charAt(i)!=str.charAt(str.length()-1-i)) {
            isPalindrome=false;
            return;
        }

        isPalindrome(str,i+1);
    }

    public static void main(String[] args) {

        System.out.println("Enter a string:");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        isPalindrome(str,0);

        System.out.println(isPalindrome);
    }
}
