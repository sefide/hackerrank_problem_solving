package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
public class NonDivisibleSubsetTest {

    @Test
    void test() {
        int k = 13;
        List<Integer> s = Arrays.asList(2375782, 21836421, 2139842193, 2138723, 23816, 21836219, 2948784, 43864923, 283648327, 23874673);

        System.out.println(nonDivisibleSubset(k, s));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        if (k == 1) {
            return 1;
        }
        Map<Integer, Long> remainders = s.stream()
                .map(i -> i % k)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        Set<Integer> removed = new HashSet<>();
        for (int r : remainders.keySet()) {
            int l = k - r;
            if (remainders.get(l) != null) {
                int remove = Math.min(remainders.get(l), remainders.get(r)) == remainders.get(l) ? l : r;
                if (!removed.contains(k - remove)) {
                    removed.add(remove);
                }
            }
        }

        return Integer.parseInt(remainders.keySet()
                .stream()
                .filter(i -> !removed.contains(i))
                .map(remainders::get)
                .reduce(0L, Long::sum)
                .toString());
    }

    /*
    ref Discussion,
    (a+b)%k = 0(means evenly divisible) then (a%k + b%k = k)
     */
}
