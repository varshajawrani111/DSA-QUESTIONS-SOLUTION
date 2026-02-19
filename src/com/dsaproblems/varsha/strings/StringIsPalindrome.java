package com.dsaproblems.varsha.strings;

import java.util.Scanner;

public class StringIsPalindrome {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string");
        String str=sc.nextLine();

        int n = str.length()-1;
        boolean palindrome = true;

        for (int i=0 ; i<=n; i++){

            if (str.charAt(i)!=str.charAt(n-i)){
                palindrome=false;
                break;
            }
        }

        System.out.println(palindrome);
    }
}
