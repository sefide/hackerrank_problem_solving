package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 */
public class MinimumDistanceTest {
    private static final int NO_DISTANCE = -1;

    @Test
    void test() {
        int[] a = {1, 2, 3, 4, 10};

        System.out.println(minimumDistances(a));
    }

    static int minimumDistances(int[] a) {
        int min = a.length;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j] && j - i < min) {
                    min = j - i;
                }
            }
        }

        return min == a.length ? NO_DISTANCE : min;
    }

}
