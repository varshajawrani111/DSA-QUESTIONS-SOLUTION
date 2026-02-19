package com.dsaproblems.varsha.patternPrinting;

import java.util.Scanner;

public class PrintCharacterPyramid {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the height of the pyramid :");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){

                char character = (char)(j+65);
                System.out.print(character);

            }
            System.out.println();
        }
    }
}
