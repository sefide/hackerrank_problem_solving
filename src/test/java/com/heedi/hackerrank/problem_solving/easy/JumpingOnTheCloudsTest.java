package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
 */
public class JumpingOnTheCloudsTest {

    @Test
    void test() {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;

        System.out.println(jumpingOnClouds(c, k));
    }

    static int jumpingOnClouds(int[] c, int k) {
        int n = c.length;
        int i = 0;
        int e = 100;

        do {
            e -= (c[(i + k) % n] * 2) + 1;
            i = (i + k) % n;
        } while (i != 0);

        return e;
    }

}
