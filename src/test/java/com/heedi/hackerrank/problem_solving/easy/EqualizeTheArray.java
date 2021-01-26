package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        Map<Integer, Long> counting = Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        long max = 0;
        for (int num: counting.keySet()) {
            if(counting.get(num) > max) {
                max = counting.get(num);
            }
        }

        return (int) (arr.length - max);
    }

}
