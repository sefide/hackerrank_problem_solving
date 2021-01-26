package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem
 */
public class EqualizeTheArray {

    @Test
    void test() {
        int[] arr = {3, 3, 2, 1, 3};

        System.out.println(equalizeArray(arr));
    }

    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> counting = new HashMap<>();

        int max = 0;
        for (int num : arr) {
            int count = 1;

            if (counting.containsKey(num)) {
                count = counting.get(num) + 1;
            }

            counting.put(num, count);
            max = Math.max(count, max);
        }

        return arr.length - max;
    }

}
