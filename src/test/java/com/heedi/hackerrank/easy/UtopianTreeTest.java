package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 */
public class UtopianTreeTest {

    @Test
    void test() {
        int n = 7;

        System.out.println(utopianTree(n));
        System.out.println(cycle(n));
        System.out.println(crazyBit(n));
    }

    // n까지 돌려서 찍어보는 방법
    static int utopianTree(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num *= 2;
            } else {
                num += 1;
            }
        }

        return num;
    }

    // 재귀함수 사용한 방법
    private int cycle(int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return cycle(--n) + 1;
        }
        return 2 * cycle(--n);
    }

    // 비트 연산을 이용한 굉장한 방법
    private int crazyBit(int n) {
//        return ((1 << ((n >> 1) + 1)) - 1) << n % 2;
        return ~(~1 << (n >> 1)) << n % 2;
    }

    @Test
    void shiftTest() {
        int n = 3;
        System.out.println(~n); // 비트 전환 연산자
        System.out.println(n >> 1);
        System.out.println(n >> 2);
        System.out.println(n);
        System.out.println(n << 1);
        System.out.println(n << 2);
    }
}
