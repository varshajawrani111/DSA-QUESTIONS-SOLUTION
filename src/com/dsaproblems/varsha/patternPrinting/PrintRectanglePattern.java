package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintRectanglePattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the rectangle");
        int n = sc.nextInt();

        System.out.println("Enter the breath of the rectangle");
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
