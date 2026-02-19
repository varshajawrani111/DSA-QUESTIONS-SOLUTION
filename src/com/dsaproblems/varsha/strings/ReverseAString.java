package com.dsaproblems.varsha.strings;

import java.util.Scanner;

public class ReverseAString {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string");
        String str=sc.nextLine();

        String[] words=str.trim().split(" "); //triming removes leading and trailing spaces

        int left=0;
        int right=words.length-1;

        while(left<right){

            String temp=words[left];
            words[left]=words[right];
            words[right]=temp;
            left++;
            right--;
        }

        str = String.join(" ",words); // this will join the

        System.out.println(str);
    }
}
