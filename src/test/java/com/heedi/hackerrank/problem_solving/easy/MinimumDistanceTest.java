package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 */
public class MinimumDistanceTest {

    @Test
    void test() {
        int[] a = {7, 1, 3, 4, 1, 7};

        System.out.println(minimumDistances(a));

    }

    static int minimumDistances(int[] a) {
        int distance = -1;

        int min = a.length;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if(a[i] == a[j] && j - i < min) {
                    min = j - i;
                }
            }
        }

        return min == a.length ? distance : min;
    }

}
