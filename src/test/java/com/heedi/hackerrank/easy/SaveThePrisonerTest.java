package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

public class SaveThePrisonerTest {

    @Test
    void test() {
        int n = 3;
        int m = 2;
        int s = 3;

        System.out.println(saveThePrisoner(n, m, s));
    }

    static int saveThePrisoner(int n, int m, int s) {
        int left = m % n;

        int position;
        if(left == 0) {
            position = s + n;
        } else {
            position = s + left - 1;
        }
        return position > n ? Math.abs(n - position) : position;

        // 12345;
        // 절대 5 - (3 + 3)
    }

}
