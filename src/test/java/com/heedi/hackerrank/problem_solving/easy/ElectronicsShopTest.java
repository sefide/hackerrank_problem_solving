package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/problem
 */
public class ElectronicsShopTest {

    @Test
    void test() {

        int[] keyboards = {3,1};
        int[] drives = {5, 2, 8};
        int b = 10;
        System.out.println(getMoneySpent(keyboards, drives, b));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int sum = -1;

        for (int keyboard : keyboards) {
            if (keyboard < b) {
                for (int drive : drives) {
                    if (drive < b) {
                        sum = keyboard + drive <= b ? Math.max(sum, keyboard + drive) : sum;
                    }
                }
            }
        }

        return sum;
    }
}
