package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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
            for (int j = i + 1; j < topic.length; j++) {
                int oneCount = 0;
                for (int k = 0; k < topic[i].length(); k++) {
                    if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
                        oneCount++;
                    }
                }
                if (oneCount > max) {
                    max = oneCount;
                    count = 1;
                } else if (oneCount == max) {
                    count++;
                }
            }
        }

        return new int[]{max, count};
    }

}
