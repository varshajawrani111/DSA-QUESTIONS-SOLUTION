package com.dsaproblems.varsha.basicMaths;

import java.util.Scanner;

public class GCDofTwoNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number");
        int n1=sc.nextInt();
        System.out.println("Enter second number");
        int n2=sc.nextInt();

        int n= Math.min(n1, n2);
        int gcd = 1;

        if(n1==0){
            gcd = n2;
        }
        if(n2==0){
            gcd = n2;
        }

        for(int i=1;i<=n;i++){
            if(n%i==0 && n2%i==0){
                gcd=i;
            }
        }
        System.out.println(gcd);

    }
}
