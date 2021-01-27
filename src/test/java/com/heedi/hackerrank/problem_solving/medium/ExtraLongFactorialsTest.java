package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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
        BigInteger result = factorials(n);

        System.out.println(result);
    }

    private static BigInteger factorials(int n) {
        if (n == 1) {
            return BigInteger.valueOf(1);
        }

        return BigInteger.valueOf(n).multiply(factorials(n - 1));
    }

    /*
    BigDecimal : Immutable, arbitrary-precision signed decimal numbers
    BigInteger : Immutable arbitrary-precision integers
     */
}
