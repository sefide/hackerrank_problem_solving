package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
public class ExtraLongFactorialsTest {

    @Test
    void test() {
        int n = 25;

        extraLongFactorials(n);
    }

    static void extraLongFactorials(int n) {
        BigDecimal result = factorials(n);

        System.out.println(result);
    }

    private static BigDecimal factorials(int n) {
        if (n == 1) {
            return new BigDecimal(1);
        }

        return BigDecimal.valueOf(n).multiply(factorials(n - 1));
    }
}
