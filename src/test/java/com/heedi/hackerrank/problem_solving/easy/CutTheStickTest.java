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
        int[] arr = {5, 4, 4, 2, 2, 8};
        int[] result = cutTheSticks(arr);

        System.out.println(Arrays.toString(result));
    }

    static int[] cutTheSticks(int[] arr) {
        int r = arr.length;
        List<Integer> list = new ArrayList<>();

        list.add(r);
        Arrays.sort(arr);
        int minIndex = 0;
        while (r != 1) {
            int min = arr[minIndex];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - min;
                if(arr[i] == 0) {
                    r--;
                    minIndex++;
                }
            }
            list.add(r);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
