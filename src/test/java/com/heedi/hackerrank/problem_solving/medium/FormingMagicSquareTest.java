package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class FormingMagicSquareTest {
    private static final int LENGTH = 3;

    private static final int[][][] pre = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}};

    @Test
    void test() {
        int[][] s = new int[LENGTH][LENGTH];
        int[] a1 = {5, 3, 4};
        System.arraycopy(a1, 0, s[0], 0, a1.length);
        int[] a2 = {1, 5, 8};
        System.arraycopy(a2, 0, s[1], 0, a2.length);
        int[] a3 = {6, 4, 2};
        System.arraycopy(a3, 0, s[2], 0, a3.length);

        System.out.println(formingMagicSquare(s));
    }

    static int formingMagicSquare(int[][] s) {
        int totals = 72;

//      for (int[][] ints : pre) {
        for (int i = 0; i < pre.length; i++) {
            int total = 0;

            for (int j = 0; j < LENGTH; j++) {
                for (int k = 0; k < LENGTH; k++) {
                    int preValue = pre[i][j][k];
                    int sValue = s[j][k];
                    if (preValue != sValue) {
                        total += Math.max(preValue, sValue) - Math.min(preValue, sValue);
                    }
                }
            }

            totals = Math.min(total, totals);
        }

        return totals;
    }
}
