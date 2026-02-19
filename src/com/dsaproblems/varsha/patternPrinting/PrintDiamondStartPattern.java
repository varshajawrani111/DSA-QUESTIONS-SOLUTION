package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintDiamondStartPattern {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the rows of a diamond:");
        //this will represent the number of rows before which triangle gets inverted
        int n=sc.nextInt();

        for(int i=1;i<=n;i++){
            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //for inverted triangle
        for(int i= n-1; i>=1;i--){ //starting with n-1 as we don't want to repeat the last row
            for(int j=n-1; j>=i; j--){
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--) {
                System.out.print("*");
            }
            for (int j=i; j>1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
