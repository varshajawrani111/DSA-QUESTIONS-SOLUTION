package com.dsaproblems.varsha.basicMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenesAlgorithm {

    //Sieve Of Eratosthenes Algorithm is the optimized approach to find the prime numbers up to N
    public static List<Integer> primeNumbers(int n) {

       boolean[] isPrime = new boolean[n+1];
       Arrays.fill(isPrime, true); //marking al numbers as prime

        //marking 0 and 1 as non prime
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j += i) { //marking the multiples of i as non-prime
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;

    }

    public static void main(String[] args) {

        System.out.println(primeNumbers(10));
    }
}
