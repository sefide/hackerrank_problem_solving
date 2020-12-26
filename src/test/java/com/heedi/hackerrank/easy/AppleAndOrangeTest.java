package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */
public class AppleAndOrangeTest {
    @Test
    void test() {
        /*
            7 11
            5 15
            3 2
            -2 2 1
            5 -6
         */

        int s = 7, t = 11;
        int a = 5, b = 15;
        int[] apples = {-2,2,1};
        int[] oranges = {5, -6};

        countApplesAndOranges(s, t, a, b, apples, oranges);

    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println(getCount(apples, a, s, t));
        System.out.println(getCount(oranges, b, s, t));
    }

    private static int getCount(int[] fruits, int point, int s, int t) {
        int result = 0;

        for (int fruit : fruits) {
            if(fruit + point >= s && fruit + point <= t) {
                result++;
            }
        }
        return result;
    }

}
