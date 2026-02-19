package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintCenteredNumberedPyramid {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the length of the pyramid :");
        int n=sc.nextInt();

        for(int i=1;i<=n;i++){
            for (int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            for(int j=1;j<i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
