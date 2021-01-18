package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
public class NonDivisibleSubsetTest {

    @Test
    void test() {
        int k = 3;
        List<Integer> s = Arrays.asList(1, 2, 4, 7);

        System.out.println(nonDivisibleSubset(k, s));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Integer> remainders = new HashMap<>();

        for (int i : s) {
            remainders.put(i % k, remainders.get(i % k) != null ? remainders.get(i % k) + 1 : 1);
        }

        Set<Integer> removed = new HashSet<>();
        for (int r : remainders.keySet()) {
            int l = k - r;
            if (remainders.get(l) != null) {
                int remove = Math.min(remainders.get(l), remainders.get(r)) == remainders.get(l) ? l : r;
                removed.add(remove);
            }
        }

        return remainders.keySet()
                .stream()
                .filter(i -> !removed.contains(i))
                .map(remainders::get)
                .reduce(0, Integer::sum);
    }

    /*
    ref Discussion,
    (a+b)%k = 0(means evenly divisible) then (a%k + b%k = k)
     */
}
