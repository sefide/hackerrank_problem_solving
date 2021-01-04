package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class CountingValleyTest {

    @Test
    void test() {
        int steps = 12;
        String path = "DDUUDDUDUUUD";
        System.out.println(countingValleys(steps, path)); // 3
    }

    public static int countingValleys(int steps, String path) {
        int result = 0;
        int level = 0;

        for (int i = 0; i < steps; i++) {
            char c = path.charAt(i);
            if(c == 'U') {
                level += 1;
                if(level == 0) {
                    result++;
                }
            } else {
                level -= 1;
            }
        }

        return result;
    }
}
