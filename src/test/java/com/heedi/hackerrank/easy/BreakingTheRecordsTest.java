package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?h_r=next-challenge&h_v=zen
 */
public class BreakingTheRecordsTest {

    @Test
    void test() {

//        int[] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] scores = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
        int[] result = breakingRecords(scores);

        System.out.println(Arrays.toString(result));
    }

    static int[] breakingRecords(int[] scores) {
        int min = 0;
        int max = 0;

        if(scores.length == 0) {
            return new int[]{max, min};
        }

        int minimum = scores[0];
        int maximum = scores[0];

        for (int score : scores) {
            if(minimum > score) {
                min++;
                minimum = score;
            } else if (maximum < score) {
                max++;
                maximum = score;
            }
        }

        return new int[]{max, min};
    }
}
