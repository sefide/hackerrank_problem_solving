package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem?h_r=next-challenge&h_v=zen
 * kangaroo
 */
public class NumberLineJumpTest {

    @Test
    void test() {
        String[] input = "0 3 4 2".split(" ");
        int x1 = Integer.parseInt(input[0]);
        int v1 = Integer.parseInt(input[1]);
        int x2 = Integer.parseInt(input[2]);
        int v2 = Integer.parseInt(input[3]);

        System.out.println(kangaroo(x1, v1, x2, v2));
    }

    // Test case 10 Time limit exceeded
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(x1 < x2 && v1 < v2) {
            return "NO";
        }
        // x1, x2
        int d1 = x1;
        int d2 = x2;
        int jump = 1;

        if(d1 < d2) {
            while (d1 < d2) {
                d1 += (jump * v1);
                d2 += (jump * v2);
            }
            if(d1 == d2) {
                return "YES";
            }
        } else {
            while (d1 > d2) {
                d1 = x1 + (jump * v1);
                d2 = x2 + (jump * v2);
            }
            if(d1 == d2) {
                return "YES";
            }
        }


        return "NO";
    }

}


