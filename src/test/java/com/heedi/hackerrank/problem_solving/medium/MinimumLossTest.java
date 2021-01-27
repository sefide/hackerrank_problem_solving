package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/minimum-loss/problem
 */
public class MinimumLossTest {
    @Test
    void test() {
        long[] price = {20, 7, 8, 2, 5};

        System.out.println(minimumLoss(price));
    }

    static int minimumLoss(long[] price) {
        long min = Long.MAX_VALUE;

        Map<Long, Integer> indexByNumber = new HashMap<>();
        for (int i = 0; i < price.length; i++) {
            indexByNumber.put(price[i], i);
        }
        long[] copied = price.clone();
        Arrays.sort(copied);

        for (int i = copied.length - 1; i > 0; i--) {
            if (copied[i] - copied[i - 1] < min
                    && indexByNumber.get(copied[i]) < indexByNumber.get(copied[i - 1])) {
                min = copied[i] - copied[i - 1];
            }
        }

        return (int) min;
    }
}
