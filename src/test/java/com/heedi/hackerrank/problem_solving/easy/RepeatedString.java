package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 */
public class RepeatedString {

    @Test
    void test() {
        String s = "a";
        long n = 1000000000000L;

        System.out.println(repeatedString(s, n));
    }

    static long repeatedString(String s, long n) {
        long result = 0;
        long mock = n / s.length(); // quotient
        int namugi = Long.valueOf(n % s.length()).intValue(); // remainder

        String filteredS = s.replaceAll("[^a]", "");
        result += mock * filteredS.length();

        if(namugi != 0) {
            String filteredAS = s.substring(0, namugi + 1).replaceAll("[^a]", "");
            result += filteredAS.length();
        }

        return result;
    }
}
