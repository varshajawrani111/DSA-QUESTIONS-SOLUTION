package com.dsaproblems.varsha.strings;

public class CountAndSay {


    public static String countAndSay(int n) {

        if(n==1)
            return "1";

        String str = countAndSay(n-1);

        StringBuilder result = new StringBuilder();


        //processing the string we got
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            int count = 1;

            while(i < str.length()-1 && str.charAt(i+1) == str.charAt(i)){
                count++;
                i++;
            }

            result.append(count).append(str.charAt(i));
            //kitni baar character hai like 2 baar ek hai "21"
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int n = 4;
        System.out.println(countAndSay(n));
    }
}
