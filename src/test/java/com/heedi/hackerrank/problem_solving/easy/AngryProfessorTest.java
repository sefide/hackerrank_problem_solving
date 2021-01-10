package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/angry-professor/problem
 */
public class AngryProfessorTest {

    @Test
    void test() {
        int k = 3;
        int[] a = {-1, -3, 4, 2};

        System.out.println(angryProfessor(k, a));
    }

    static String angryProfessor(int k, int[] a) {
        long attendeesNumber = Arrays.stream(a)
                .filter(time -> time <= 0)
                .count();

        return attendeesNumber >= k ? "NO" : "YES";
    }
}
