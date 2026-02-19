package com.dsaproblems.varsha.basicMaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintPrimeNumbersInRange {

    public static boolean checkPrime(int n)
    {
        boolean prime = true;
        if(n <= 1)
            return false;

        if (n==2)
            return true;

        if(n%2==0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false;
            }
        }

        return prime;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the range of prime numbers:");
        int n=sc.nextInt();

        List<Integer> list=new ArrayList<>();

        for (int i=1;i<=n;i++){
            if(checkPrime(i))
                list.add(i);
        }

        System.out.println(list);
    }
}
