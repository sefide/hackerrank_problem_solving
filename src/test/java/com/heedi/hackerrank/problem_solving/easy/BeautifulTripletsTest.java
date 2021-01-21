package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * https://www.hackerrank.com/challenges/beautiful-triplets/problem
 */
public class BeautifulTripletsTest {

    @Test
    void test() {
        int d = 3;
        int[] arr = {1, 2, 4, 5, 7, 8, 10};
//        int[] arr = {1, 6, 7, 7, 8, 10, 12, 13, 14, 19};

        System.out.println(beautifulTriplets(d, arr));
    }

    static int beautifulTriplets(int d, int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        int count = 0;
        for (int number : map.keySet()) {
            int big1 = number + d;
            int big2 = number + (d * 2);

            if(map.containsKey(big1) && map.containsKey(big2)) {
                long max = Math.max(map.get(number), map.get(big1));
                count += Math.max(max, map.get(big2));
            }
        }

        return count;
    }

}
