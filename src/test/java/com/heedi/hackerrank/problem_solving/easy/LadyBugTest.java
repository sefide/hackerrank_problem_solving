package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

public class LadyBugTest {
    private static final String EMPTY_STRING = "_";

    @Test
    void test() {
        String b = "RBY_YBR";
        System.out.println(happyLadybugs(b));
    }

    static String happyLadybugs(String b) {
        String filtered = b.replaceAll(EMPTY_STRING, "");
        // "_"만 존재하는 경우
        if (filtered.length() == 0) {
            return "YES";
        }

        boolean flag = false;

        // 알파벳이 쌍을 이루지 않는 경우
        String s = filtered;
        for (int i = 0; i < s.length(); ) {
            char temp = s.charAt(i);
            int last = s.lastIndexOf(temp);
            if (last == -1 || i == last) {
                return "NO";
            }

            for (int j = i; j <= last; j++) {
                if (temp != s.charAt(j)) {
                    flag = true;
                    break;
                }
            }

            s = s.replaceAll(String.valueOf(temp), "");
        }

        // 빈 공간이 없는 경우
        if (flag && !b.contains(EMPTY_STRING)) {
            return "NO";
        }

        return "YES";
    }
}
