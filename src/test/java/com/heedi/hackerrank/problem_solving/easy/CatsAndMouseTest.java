package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 */
public class CatsAndMouseTest {

    @Test
    void test() {
        int x = 0;
        int y = 0;
        int z = 0;
        System.out.println(catAndMouse(x, y, z));
    }

    static String catAndMouse(int x, int y, int z) {
        int d1 = Math.abs(x - z);
        int d2 = Math.abs(y - z);

        return d1 == d2 ? "Mouse C" : d1 < d2 ? "Cat A" : "Cat B";
    }

}
