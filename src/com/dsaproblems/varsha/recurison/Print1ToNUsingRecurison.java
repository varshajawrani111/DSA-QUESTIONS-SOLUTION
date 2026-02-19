package com.dsaproblems.varsha.recurison;

import java.util.Scanner;

public class Print1ToNUsingRecurison {

    public static void print(int n)
    {
        //Base case
        if (n == 0)
            return;

        print(n-1);
        System.out.print(n);
    }

    public static void main(String[] args) {

        System.out.println("Enter the value of N");
        int n = new Scanner(System.in).nextInt();

        print(n);
    }
}
