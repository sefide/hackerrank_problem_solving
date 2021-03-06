package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/save-the-prisoner/problem
 */
public class SaveThePrisonerTest {

    @Test
    void test() {
        int n = 3;
        int m = 2;
        int s = 3;

        System.out.println(saveThePrisoner(n, m, s));
    }

    static int saveThePrisoner(int n, int m, int s) {
        return ((s - 1) + (m - 1)) % n + 1;
    }

}
