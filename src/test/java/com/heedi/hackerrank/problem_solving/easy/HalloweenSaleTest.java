package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.hackerrank.com/challenges/halloween-sale/problem
 */
public class HalloweenSaleTest {

    @Test
    void test() {
        assertEquals(howManyGames(20, 3, 6, 80), 6);
        assertEquals(howManyGames(20, 3, 6, 85), 7);
        assertEquals(howManyGames(100, 12, 55, 95), 0);

        assertEquals(howManyGames2(20, 3, 6, 80), 6);
        assertEquals(howManyGames2(20, 3, 6, 85), 7);
        assertEquals(howManyGames2(100, 12, 55, 95), 0);
    }

    static int howManyGames(int p, int d, int m, int s) {
        int result = 0;
        while (s >= m && p <= s) {
            s -= p;
            if (p - d >= m) {
                p -= d;
            } else {
                p = m;
            }
            result += 1;
        }
        return result;
    }

    static int howManyGames2(int p, int d, int m, int s) {
        if (s < p) return 0;
        return howManyGames(Math.max(m, p - d), d, m, s - p) + 1;
    }
}
