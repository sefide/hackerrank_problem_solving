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
                BigInteger binaryToDecimal1 = BigInteger.valueOf(Integer.parseInt(topic[i], 2));
                BigInteger binaryToDecimal2 = BigInteger.valueOf(Integer.parseInt(topic[j], 2));

                BigInteger bigInteger = binaryToDecimal1.or(binaryToDecimal2);
                int oneCount = bigInteger.bitCount();;

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
