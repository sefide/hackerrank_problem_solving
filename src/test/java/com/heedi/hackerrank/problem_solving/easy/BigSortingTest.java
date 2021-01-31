package com.heedi.hackerrank.problem_solving.easy;

import com.heedi.hackerrank.utils.FileScanUtils;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 */
public class BigSortingTest {

    @Test
    void test() throws FileNotFoundException {
        String[] array
                = FileScanUtils.getArrays("src/test/java/com/heedi/hackerrank/resources/easy/BigSortingInput01.txt");

//        array = sortedWithString(array);
        array = bigSorting(array);
        System.out.println(Arrays.toString(array));
    }

    private static String[] sortedWithString(String[] array) {
        List<String> sorted = Arrays.stream(array)
                .sorted(CustomCompare::compareTo)
                .collect(Collectors.toList());

        String[] result = new String[array.length];
        sorted.toArray(result);

        return result;
    }

    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, CustomCompare::compareTo2);
        return unsorted;
    }

}

class CustomCompare {
    public static int compareTo2(String s1, String s2) {
        return s1.length() == s2.length() ? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length());
    }

    public static int compareTo(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        return 0;
    }
}

