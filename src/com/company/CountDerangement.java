package com.company;

import java.util.Arrays;

public class CountDerangement {

    public static void main(String[] args) {
        System.out.println(countDerangementRec(13));
    }

    private static long countDerangementRec(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return (n - 1) * (countDerangementRec(n - 1) + countDerangementRec(n - 2));
    }


    private static long countDerangementTopDownMemoization(int n) {
        long[] subSolutions = new long[n];
        Arrays.fill(subSolutions, -1);
        return countDerangementTopDownMemoization(n, subSolutions);
    }

    private static long countDerangementTopDownMemoization(int n, long[] subSolutions) {
        if (subSolutions[n] != -1) return subSolutions[n];
        if (n == 1) return 0;
        if (n == 2) return 1;
        Long result = (n - 1) * (countDerangementTopDownMemoization(n - 1) + countDerangementTopDownMemoization(n - 2));
        subSolutions[n] = result;
        return result;
    }

    private static long countDerangementBottomUpTabulation(int n, long[] subSolutions) {
        for (int i = 1; i < n; i++) {
            if (n == 1) subSolutions[n] = 0;
            else if (n == 2) subSolutions[n] = 1;
            else subSolutions[n] = (n - 1) * (subSolutions[n - 1] + subSolutions[n - 2]);
        }
        return subSolutions[subSolutions.length - 1];
    }


    private static long countDerangementOptimized(int n) {
        long nMinus1 = 0, nMinus2 = 0, res = 0;
        for (int i = 1; i < n; i++) {
            if(n == 1) res = 0;
            if(n == 2) res = 1;
            res = (n - 1) * (nMinus1 + nMinus2);
            nMinus2 = nMinus1;
            nMinus1 = res;
        }
        return res;
    }
}












