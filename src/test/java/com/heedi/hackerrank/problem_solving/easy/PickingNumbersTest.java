package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickingNumbersTest {

    @Test
    void test() {
        List<Integer> a = Arrays.asList(4, 6, 5, 3, 3, 1);

        System.out.println(pickingNumbers(a));
    }

    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> countByNumber = new HashMap<>();

        for (Integer i : a) {
            if (countByNumber.get(i) != null) {
                countByNumber.put(i, countByNumber.get(i) + 1);
                continue;
            }
            countByNumber.put(i, 1);
        }

        int max = 0;

        for (Integer key : countByNumber.keySet()) {
            int count = countByNumber.get(key);

            if(countByNumber.get(key + 1) != null) {
                count += countByNumber.get(key + 1);
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
