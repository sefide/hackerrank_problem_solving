package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class SubArrayDivisionTest {

    @Test
    void test() {
        int[] array = {1,2,1,3,2};
        List s = Arrays.asList(array); // List<Integer> 불가
//        List<Integer> s1 = Arrays.asList(array); // array가 Integer[]라면 가능
        int d = 3;
        int m = 2;

        System.out.println(birthday(s, d, m));
        System.out.println(birthdayUsingArray(array, d, m));
    }

    private int birthdayUsingArray(int[] s, int d, int m) {
        int result = 0;

        for (int i = 0; i <= s.length - m; i++) {
            int sum = Arrays.stream(s, i, i+m).sum();

            if(sum == d) {
                result++;
            }
        }

        return result;
    }

    static int birthday(List<Integer> s, int d, int m) {
        int result = 0;

        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            if(sum == d) {
                result++;
            }
        }

        return result;
    }

}
