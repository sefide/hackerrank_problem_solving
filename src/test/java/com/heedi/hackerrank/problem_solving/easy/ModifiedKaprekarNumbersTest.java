package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
public class ModifiedKaprekarNumbersTest {

    @Test
    void test() {
        kaprekarNumbers(1, 100); // 1 9 45 55 99
        kaprekarNumbers(100, 300); // 297
        kaprekarNumbers(400, 700); // INVALID RANGE
        kaprekarNumbers(1, 99999); // 1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
    }

    static void kaprekarNumbers(int p, int q) {
        List<String> result = new ArrayList<>();
        for (int i = p; i <= q; i++) {
            BigDecimal mul = BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(i));
            String s = mul.toString();

            String rString = s.substring(s.length() / 2);
            String lString = s.substring(0, s.length() / 2);
            BigDecimal r = new BigDecimal(rString);
            BigDecimal l = BigDecimal.ZERO;
            if (s.length() != 1) {
                l = new BigDecimal(lString);
            }


            if (r.add(l).toString().equals(String.valueOf(i))) {
                result.add(String.valueOf(i));
            }
        }
        if (result.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println(String.join(" ", result));
        }
    }
}
