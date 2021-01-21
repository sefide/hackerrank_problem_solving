package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/acm-icpc-team/problem
 */
public class ACMICPCTeamTest {

    @Test
    void test() {
        String[] topic = {"10101", "11100", "11010", "00101"};
        int[] result = acmTeam(topic);

        System.out.println(Arrays.toString(result));
    }

    static int[] acmTeam(String[] topic) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < topic.length - 1; i++) {
            long binaryToDecimal1 = Integer.parseInt(topic[i], 2);
            long binaryToDecimal2 = Integer.parseInt(topic[i + 1], 2);

            long s = binaryToDecimal1 | binaryToDecimal2;
            String binaryString = Long.toBinaryString(s);
            int oneCount = binaryString.replaceAll("[^1]", "").length();

            if (oneCount > max) {
                max = oneCount;
                count = 1;
            } else if (s == max) {
                count++;
            }
        }

        return new int[]{max, count};
    }

}
