package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SalesByMatchTest {

    @Test
    void test() {
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchantUsingSet(n, ar));
        System.out.println(sockMerchant(n, ar));
    }

    static int sockMerchantUsingSet(int n, int[] ar) {
        int result = 0;

        Set<Integer> set = new HashSet<>();
        for (int i : ar) {
            if(set.contains(i)) {
                result++;
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        return result;
    }

    static int sockMerchant(int n, int[] ar) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : ar) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i: map.values()) {
            result += i / 2;
        }
        return result;
    }

}
