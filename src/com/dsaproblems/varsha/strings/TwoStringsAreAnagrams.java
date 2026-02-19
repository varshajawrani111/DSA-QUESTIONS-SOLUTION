package com.dsaproblems.varsha.strings;

import java.util.Scanner;

public class TwoStringsAreAnagrams {

    public static boolean checkAnagrams(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }

        int[] freq=new int[26];

        for(int i=0;i<a.length();i++){
            freq[a.charAt(i)-'a']++;
            freq[b.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string");
        String st1=sc.nextLine();

        System.out.println("Enter a string");
        String str2=sc.nextLine();

        System.out.println(checkAnagrams(st1,str2));
    }
}
