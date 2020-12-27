package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/between-two-sets/problem?h_r=next-challenge&h_v=zen
 */
public class BetweenTwoSetsTest {

    @Test
    void test() {
        List<Integer> a = Arrays.asList(2, 6);
        List<Integer> b = Arrays.asList(24, 36);

        System.out.println(getTotalX(a, b));
    }

    // 지저분한 for문 중복 해결 필요
    // JS 경우, every()로 간단하게 해결 가능
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        for (int x = 1; x <= 100; x++) {
            for (int i = 0; i < a.size(); i++) {
                if (x % a.get(i) != 0) {
                    break;
                }
                if (i == a.size() - 1) {
                    for (int j = 0; j < b.size(); j++) {
                        if (b.get(j) % x != 0) {
                            break;
                        }
                        if (j == b.size() - 1) {
                            result++;
                            System.out.println(x);
                        }
                    }
                }
            }
        }

        return result;
    }

}
