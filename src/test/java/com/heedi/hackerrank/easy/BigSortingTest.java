package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BigSortingTest {

    @Test
    void test() throws FileNotFoundException {
        List<String> test = new ArrayList<>();
        File file = new File("src/test/java/com/heedi/hackerrank/resources/easy/BigSortingInput01.txt");
        //스캐너로 파일 읽기
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            test.add(scan.nextLine());
        }

        String[] array = new String[test.size()];
        test.toArray(array);

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

