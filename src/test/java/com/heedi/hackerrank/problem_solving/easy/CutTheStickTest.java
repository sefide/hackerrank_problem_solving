package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem
 */
public class CutTheStickTest {

    @Test
    void test() {
        int[] arr = {3,3,3};
        int[] result = cutTheSticks(arr);
        int[] resultUsingLength = cutTheSticksUsingLength(arr);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(resultUsingLength));
    }

    static int[] cutTheSticks(int[] arr) {
        int r = arr.length;
        List<Integer> list = new ArrayList<>();

        list.add(r);
        Arrays.sort(arr);
        int minIndex = 0;
        while (r > 1) {
            int min = arr[minIndex];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - min;
                if (arr[i] == 0) {
                    r--;
                    minIndex++;
                }
            }

            if (r != 0) {
                list.add(r);
            }
        }

        return convertListToArray(list);
    }

    static int[] cutTheSticksUsingLength(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        list.add(arr.length);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                list.add(arr.length - i);
            }
        }

        return convertListToArray(list);
    }

    private static int[] convertListToArray(List<Integer> list) {
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
