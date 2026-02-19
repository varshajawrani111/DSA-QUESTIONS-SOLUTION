package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintRightAlignedTriangle {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the lenght of the triangle");
        int n=sc.nextInt();

        for(int i= 1; i<=n; i++){

            //to print spaces
            for(int j=1 ; j<=n-i ; j++){
                System.out.print(" ");
            }

            //to print asterisks
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
