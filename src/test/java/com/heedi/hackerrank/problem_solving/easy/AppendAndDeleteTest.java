package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.time.Year;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 */
public class AppendAndDeleteTest {
    private static final String YES = "Yes";
    private static final String NO = "No";

    @Test
    void test() {
        String s = "aba";
        String t = "aba";
        int k = 7;
        System.out.println(appendAndDelete(s, t, k));
    }

    static String appendAndDelete(String s, String t, int k) {
        int sLength = s.length();
        int tLength = t.length();

        int i;
        for (i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        int shouldFixCount = sLength - i + tLength - i;
        if (shouldFixCount == k || k >= sLength + tLength) {
            return "Yes";
        } else if (shouldFixCount < k && shouldFixCount % 2 == k % 2) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
