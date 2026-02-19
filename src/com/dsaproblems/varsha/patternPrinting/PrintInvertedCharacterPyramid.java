package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintInvertedCharacterPyramid {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the length of the pyramid :");
        int length=sc.nextInt();

        for(int i=length-1;i>=0;i--){

            //this so that every row of pyramid starts with A
            char charcter = 'A';

            for(int j=i;j>=0;j--){

                System.out.print(charcter);
                charcter++;

            }
            System.out.println();
        }

    }
}
