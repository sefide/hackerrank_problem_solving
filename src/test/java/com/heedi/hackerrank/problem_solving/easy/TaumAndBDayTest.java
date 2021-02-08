package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/taum-and-bday/problem
 */
public class TaumAndBDayTest {

    @Test
    void test() {
        // Taum and B'day , 25, 89.40%
        int b = 3;
        int w = 6;
        int bc = 1;
        int wc = 1;
        int z = 1;

        System.out.println(taumBday(b, w, bc, wc, z));
    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        if (bc > wc + z) {
            return (b + w) * wc + b * z;
        }

        if (wc > bc + z) {
            return (b + w) * bc + w * z;
        }

        return (b * bc) + (w * wc);
    }

}
