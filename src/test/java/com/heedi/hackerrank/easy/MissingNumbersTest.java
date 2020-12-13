package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbersTest {

    @Test
    void test() {
        int[] arr = {11, 4, 11, 7, 13, 4, 12, 11, 10, 14};
        int[] brr = {11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12};
//        int[] arr = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
//        int[] brr = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int[] result = missingNumbers(arr, brr);

        System.out.println(Arrays.toString(result));
    }

    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> arrCount = new HashMap<>();
        Map<Integer, Integer> brrCount = new HashMap<>();
        for (int i = 0; i < brr.length; i++) {
            if (brrCount.get(brr[i]) != null) {
                brrCount.put(brr[i], brrCount.get(brr[i]) + 1);
            } else {
                brrCount.put(brr[i], 1);
            }
        }

        for (int value : arr) {
            arrCount.merge(value, 1, Integer::sum);
        }

        List<Integer> diff = new ArrayList<>();
        for (Integer key : brrCount.keySet()) {
            int count = brrCount.get(key);
            if(arrCount.get(key) == null || arrCount.get(key) != count) {
                diff.add(key);
            }
        }
        List<Integer> resultList = diff.stream()
                .sorted()
                .collect(Collectors.toList());
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
