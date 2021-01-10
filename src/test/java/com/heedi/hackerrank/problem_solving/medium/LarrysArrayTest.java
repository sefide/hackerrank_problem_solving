package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LarrysArrayTest {
    @Test
    void test() {
//        int[] A = {3,1,2};
//        {3,1,2}
//        {2,3,1}
//        {1,2,3}
//        int[] A = {1, 3, 4, 2};
//        int[] A = {1, 2, 3, 6, 4, 5, 7};
        int[] A = {1,6,5,2,4,3};
        System.out.println(solution(A));
    }

    private String solution(int[] a) {
        int[] copy = a.clone();
        Arrays.sort(copy);

        for (int i = 0; i < a.length; i++) {
            if (a[i] == copy[i]) {
                continue;
            }
            boolean result = sort(i, a);

            if (!result) {
                return "NO";
            }
        }
        return "YES";
    }

    private boolean sort(int i, int[] a) {
        if (i < a.length - 2) {
            int minIndex = a[i] < a[i + 1] ? i : i + 1;
            minIndex = a[minIndex] < a[i + 2] ? minIndex : i + 2;

            if (minIndex == i) {
                return true;
            }

            // 3 1 2
            // 0 1 2
            int temp = a[minIndex];
            if (minIndex == i + 2) {
                a[minIndex] = a[minIndex - 1];
                a[minIndex - 1] = a[minIndex - 2];
                a[minIndex - 2] = temp;
            } else {
                a[minIndex] = a[minIndex + 1];
                a[minIndex + 1] = a[minIndex - 1];
                a[minIndex - 1] = temp;
            }
            return true;
        }
        return false;
    }
}
