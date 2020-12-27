package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

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

    /*
        think.. (수학적으로 접근하기)
        x1 + (jump * v1) == x2 + (jump * v2)
        x1 - x2 = jump * (v2 - v1)
        1 = jump(v2 - v1)/(x1 - x2)
        jump = (x1 - x2)/(v2 - v1)

        jump가 정수가 나와야한다. 따라서 아래 조건을 만족한다면 됨.. !!!!
        (x1 - x2) % (v2 - v1) == 0
     */
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 <= v2) {
            return "NO";
        }

        int namuji = (x1 - x2) % (v2 - v1);
        return namuji == 0 ? "YES" : "NO";
    }

}


