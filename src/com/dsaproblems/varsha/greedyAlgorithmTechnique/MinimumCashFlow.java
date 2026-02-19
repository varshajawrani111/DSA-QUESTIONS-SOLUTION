package com.dsaproblems.varsha.greedyAlgorithmTechnique;

import java.util.*;

public class MinimumCashFlow {

    static void simplifyDebts(int[] net) {
        while (true) {
            int maxCredit = getMax(net);  // person who will receive max
            int maxDebit = getMin(net);   // person who will pay max

            if (net[maxCredit] == 0 && net[maxDebit] == 0) {
                break;  // All settled
            }

            int amount = Math.min(-net[maxDebit], net[maxCredit]);
            /*
            * They cannot transfer more than:
            * what the creditor needs
            * OR what the debtor can pay that is why minimum amount that can be transferred*/

            net[maxCredit] -= amount;
            net[maxDebit] += amount;

            System.out.println("Person " + maxDebit + " pays "
                    + amount + " to Person " + maxCredit);
        }
    }

    static int getMin(int[] net) {
        int idx = 0;
        for (int i = 1; i < net.length; i++)
            if (net[i] < net[idx])
                idx = i;
        return idx;
    }

    static int getMax(int[] net) {
        int idx = 0;
        for (int i = 1; i < net.length; i++)
            if (net[i] > net[idx])
                idx = i;
        return idx;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 50, 0}, //this means 0 owes 1 50
                {0, 0, 30}, // this means 1 owes 2 30
                {20, 0, 0}  // this means 2 owes 0 20
        };

        int n = graph.length;
        int[] net = new int[n];

        for (int p = 0; p < n; p++) {
            for (int q = 0; q < n; q++) {
                net[p] += (graph[q][p] - graph[p][q]); //money received - money given
            }
        }

        simplifyDebts(net);
    }
}

