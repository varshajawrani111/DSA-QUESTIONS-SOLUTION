package com.dsaproblems.varsha.basicMaths;

import java.util.Scanner;

public class CheckArmstrongNumber {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number");
        int n=sc.nextInt();

        int num=n;

        int digits = 0;

        double armstrong=0;

        while(n!=0){

            n=n/10;
            digits++;
        }

        int temp = num;
        while(temp!=0){


            armstrong = armstrong + Math.pow(temp%10,digits); //temp%10 to get last digit of the number
            temp = temp/10; //to remove last digit
        }

        System.out.println(num == armstrong);
    }
}
