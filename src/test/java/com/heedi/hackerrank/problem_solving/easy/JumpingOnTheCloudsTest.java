package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */
public class JumpingOnTheCloudsTest {

    @Test
    void test() {
//        int[] c = {0, 0, 1, 0, 0, 1, 0};
        int[] c = {0, 0, 0, 1, 0, 0};

        System.out.println(jumpingOnClouds(c));
    }

    static int jumpingOnClouds(int[] c) {
        int jump = 0;

        for (int i = 0; i < c.length - 1; jump++) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else {
                i += 1;
            }
        }

        return jump;
    }

}
