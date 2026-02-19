package com.dsaproblems.varsha.basicMaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckArmStrongNumberInRange {

    public static int countDigits(int n){

        int digits=0;

        while(n!=0){
            n=n/10;
            digits++;
        }
        return digits;
    }

    public static int checkArmStrongNumber(int n, int digits){

        double armstrong=0;
        while(n!=0){

            armstrong = armstrong + Math.pow(n%10,digits); //temp%10 to get last digit of the number
            n = n/10; //to remove last digit
        }

        return (int)armstrong;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("enter the range of Arm Strong Number");
        int low=sc.nextInt();
        int high=sc.nextInt();

        List<Integer> armStrongNumbers =new ArrayList<>();


        for (int i=low;i<=high;i++){

            int digits = countDigits(i);
            if(i == checkArmStrongNumber(i,digits)) {
                armStrongNumbers.add(i);
            }
        }

        System.out.println(armStrongNumbers);

    }
}
