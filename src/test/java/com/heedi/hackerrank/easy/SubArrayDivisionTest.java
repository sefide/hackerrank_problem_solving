package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class SubArrayDivisionTest {

    @Test
    void test() {
        List<Integer> s = Arrays.asList(1,2,1,3,2);
        int d = 3;
        int m = 2;

        System.out.println(birthday(s, d, m));
    }

    static int birthday(List<Integer> s, int d, int m) {
        int result = 0;

        // d = 함
        // m 연속 개수
        if (s.size() == 1) {
            return s.get(0) == d ? 1 : 0;
        }

        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            if(sum == d) {
                result++;
            }
        }

        return result;
    }

}
