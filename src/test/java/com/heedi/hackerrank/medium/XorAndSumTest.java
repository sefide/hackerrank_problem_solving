package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

public class XorAndSumTest {
    @Test
    void test() {
        /*
        xor means exclusive OR operation,
        operation shl means binary shift to the left.
         */

        /*
        exclusive OR
        0 @ 0 = 0
        1 @ 1 = 0
        0 @ 1 = 1
        1 @ 0= 1
         */

        // 314159
        // (i = 0 ~ 314159) a xor (b shl i)

        int max = 314159;
        int a = 10;
        int b = 1010;

        int result = 0;
        for (int i = 0; i <= 314159; i++) {
            result += a ^ (b<<i);
//            result += a+b-2*(a&(b<<i));
        }
        System.out.println(result%(Math.pow(10,9) + 7));
    }
}
