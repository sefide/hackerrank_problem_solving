package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumberTest {
    @Test
    void test() {
        int[] arr = {1, 23, 41};

        List<Integer> result = new ArrayList<>();

        int min = (int) (Math.pow(10, 7) - Math.pow(-10, 7));

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);

            if (min < diff) {
                continue;
            }
            if (min > diff) {
                result = new ArrayList<>();
            }

            min = diff;
            result.add(arr[i]);
            result.add(arr[i + 1]);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        System.out.println(resultArray);
    }

}