package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/find-digits/problem
 */
public class FindDigitsTest {

    @Test
    void test() {
        int n = 1012;
        System.out.println(findDigits(n));
    }

    static int findDigits(int n) {
        return (int) String.valueOf(n)
                .chars()
                .boxed()
                .distinct()
                .filter(i -> i != 0 && n % i == 0)
                .count();
    }
}
