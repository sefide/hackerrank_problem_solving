package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 */
public class UtopianTreeTest {

    @Test
    void test() {
        int n = 0;

        System.out.println(utopianTree(n));
    }

    static int utopianTree(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                num *= 2;
            } else {
                num += 1;
            }
        }

        return num;
    }

}
