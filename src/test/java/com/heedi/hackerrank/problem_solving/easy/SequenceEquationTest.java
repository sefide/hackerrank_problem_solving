package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/permutation-equation/problem
 */
public class SequenceEquationTest {

    @Test
    void test() {
        int[] p = {2, 3, 1};

        System.out.println(Arrays.toString(permutationEquation(p)));
    }

    static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        List<Integer> list = Arrays.stream(p)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 1; i <= p.length; i++) {
            int t = list.indexOf(i);
            int r = list.indexOf(t);
            result[i - 1] = r;
        }
        return result;
    }
}
