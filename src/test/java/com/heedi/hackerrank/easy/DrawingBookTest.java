package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/drawing-book/problem
 */
public class DrawingBookTest {

    @Test
    void test() {
        int n = 6;
        int p = 3;

        System.out.println(pageCount(n, p));
    }

    static int pageCount(int n, int p) {
        if (n / 2 >= p) {
            return p / 2;
        } else {
            return n / 2 - p / 2;
        }
    }
}
