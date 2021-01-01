package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */
public class DivisibleSumPairsTest {

    @Test
    void test() {
        int n = 6;
        int k = 3;
        int[] ar = {1, 3, 2, 6, 1, 2};

        System.out.println(divisibleSumPairs(n, k, ar));
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((ar[i] + ar[j])% k == 0) {
                    result++;
                }
            }

        }

        return result;
    }
}
