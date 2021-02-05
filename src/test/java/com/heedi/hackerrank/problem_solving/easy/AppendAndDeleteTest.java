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
        int sameCount = 0;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                sameCount++;
            }
        }

        int shouldFixCount = (s.length() + t.length() - (2 * sameCount));

        if (shouldFixCount > k) {
            return NO;
        }
        else if (shouldFixCount % 2 == k % 2) {
            return YES;
        }
        else if ((s.length() + t.length() - k) < 0) {
            return YES;
        }
        else {
            return NO;
        }
    }
}
