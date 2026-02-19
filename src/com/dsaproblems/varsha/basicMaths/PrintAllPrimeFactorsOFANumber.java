package com.dsaproblems.varsha.basicMaths;

import java.util.*;

public class PrintAllPrimeFactorsOFANumber {

    public static List<Integer> getPrimeFactors(int num) {
        List<Integer> primeFactors = new ArrayList<>();

        // divide by 2
        while (num % 2 == 0) {
            primeFactors.add(2);
            num /= 2;
        }

        // divide by odd numbers
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        }

        // if prime > 2 remains
        if (num > 2) {
            primeFactors.add(num);
        }

        return primeFactors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = sc.nextInt();

        List<Integer> factorsPrime = getPrimeFactors(n);

        System.out.println("Prime factorization: " + factorsPrime);
    }
}
