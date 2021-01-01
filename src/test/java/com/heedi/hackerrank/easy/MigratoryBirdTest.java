package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 */
public class MigratoryBirdTest {

    @Test
    void test() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);

        System.out.println(migratoryBirds(arr));
    }

    static int migratoryBirds(List<Integer> arr) {
        int maxKey = 0;
        long max = 0;

        Map<Integer, Long> map = arr.stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        for (Integer key : map.keySet()) {
            long count = map.get(key);

            if((count > max) || (count == max && maxKey > key)) {
                maxKey = key;
                max = count;
            }
        }

        return maxKey;
    }
}
