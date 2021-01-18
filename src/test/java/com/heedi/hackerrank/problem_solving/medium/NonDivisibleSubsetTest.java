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
        int k = 7;
//        List<Integer> s = Arrays.asList(2375782, 21836421, 2139842193, 2138723, 23816, 21836219, 2948784, 43864923, 283648327, 23874673); // k = 13
//        List<Integer> s = Arrays.asList(1, 7, 2, 4); // k = 3
        List<Integer> s = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436); // k = 7
        System.out.println(nonDivisibleSubset(k, s));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Long> remainders = s.stream()
                .map(i -> i % k)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        int count = 0;
        Set<Integer> removed = new HashSet<>();

        for (int r : remainders.keySet()) {
            if (r == (double)k / 2 || r == 0) {
                count += 1;
            } else if (!removed.contains(k - r) && !removed.contains(r)) {
                int remove;

                if(remainders.get(k - r) != null) {
                    if(remainders.get(r) < remainders.get(k - r)) {
                        remove = r;
                    } else {
                        remove = k - r;
                    }
                    count += remainders.get(k - remove);
                    removed.add(remove);
                } else {
                    count += remainders.get(r).intValue();
                }
            }
        }

        return count;
    }

    /*
    ref Discussion,
    (a+b)%k = 0(means evenly divisible) then (a%k + b%k = k)
     */
}
