package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 */
public class BeautifulDaysMoviesTest {

    @Test
    void test() {
        int i = 20;
        int j = 23;
        int k = 6;

        System.out.println(beautifulDays(i, j, k));
    }

    static int beautifulDays(int i, int j, int k) {
        int result = 0;

        for (int number = i; number <= j; number++) {
            StringBuilder stringBuffer = new StringBuilder();
            stringBuffer.append(number);
            int reverse = Integer.parseInt(stringBuffer.reverse().toString());

            if ((number - reverse) % k == 0 ) {
                result++;
            }
        }
        return result;
    }
}
