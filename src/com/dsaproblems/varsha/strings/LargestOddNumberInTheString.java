package com.dsaproblems.varsha.strings;

import java.util.Scanner;

public class LargestOddNumberInTheString {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string");
        String str = sc.nextLine();

        int index = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = str.charAt(i) - '0'; //Converts a digit character → integer digit

            if (digit % 2 != 0) {  // odd digit found
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("");
        } else {
            System.out.println(str.substring(0, index + 1));
        }

    }
}
