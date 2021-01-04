package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class CountingValleyTest {

    @Test
    void test() {
        int steps = 12;
        String path = "DDUUDDUDUUUD";
        System.out.println(countingValleys(steps, path));
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
