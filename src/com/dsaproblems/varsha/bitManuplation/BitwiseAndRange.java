package com.dsaproblems.varsha.bitManuplation;

public class BitwiseAndRange {

    public static int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;

        while (left != right) {
            //right shifting the ranges
            left >>= 1;
            right >>= 1;
            shifts++;
        }

        return left << shifts; //shifting back the result
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7)); // Output: 4
    }
}

