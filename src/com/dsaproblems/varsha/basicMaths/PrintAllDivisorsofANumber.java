package com.dsaproblems.varsha.basicMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrintAllDivisorsofANumber {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a number");
        int n=sc.nextInt();

        List<Integer> divisors = new ArrayList<>();

        for(int i=1;i<=Math.sqrt(n);i++){

            if(n%i == 0){
                divisors.add(i);

                if (i != n / i) { // Avoid adding the same divisor twice for perfect squares
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);

        System.out.println(divisors);

    }
}
