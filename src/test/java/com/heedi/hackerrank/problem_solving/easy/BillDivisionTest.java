package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class BillDivisionTest {

    private static final String BON_APPETIT = "Bon Appetit";

    @Test
    void test() {
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        int k = 1; // didn't eat
        int b = 12; // charged

        bonAppetit(bill, k, b);
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = bill.stream()
                .reduce(Integer::sum)
                .orElse(0) - bill.get(k);

        int realCharge = b - (sum / 2);
        System.out.println(realCharge == 0 ? BON_APPETIT : realCharge);
    }

}
