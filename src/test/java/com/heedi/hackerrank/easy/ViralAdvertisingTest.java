package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/strange-advertising/problem
 */
public class ViralAdvertisingTest {

    @Test
    void test() {
        int n = 3;

        System.out.println(viralAdvertising(n));
    }

    static int viralAdvertising(int n) {
        int sum = 0;

        double shared = 5.0;
        for (int i = 0; i < n; i++) {
            double liked = Math.floor(shared / 2);
            sum += liked;
            shared = liked * 3;
        }

        return sum;
    }
}
