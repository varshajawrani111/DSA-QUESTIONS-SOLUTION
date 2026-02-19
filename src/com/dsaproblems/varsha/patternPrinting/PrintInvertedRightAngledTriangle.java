package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintInvertedRightAngledTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the height of the triangle");
        int height = sc.nextInt();

        for(int i = height; i >= 1; i--){
            for(int j = i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
