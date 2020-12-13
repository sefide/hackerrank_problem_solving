package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FullCountingSortTest {
    @Test
    void test() throws IOException {
        List<List<String>> arr = new ArrayList<>();

        File file = new File("src/test/java/com/heedi/hackerrank/medium/FullCountingSortInput01.txt");
        //스캐너로 파일 읽기
        Scanner scan = new Scanner(file);

        Map<Integer, List<String>> map = new HashMap<>(100);
        int n = Integer.parseInt(scan.nextLine().trim());
        int half = n / 2;

        for(int i = 0; i < 100; i++) {
            map.put(i, new ArrayList<>());
        }

        IntStream.range(0, n).forEach(i -> {
            String[] tmp = scan.nextLine().split(" ");
            int key = Integer.parseInt(tmp[0]);
            String value = i < half ? "-" : tmp[1];

            List<String> arrays = map.get(key);
            arrays.add(value);

        });

        printResult(map);

    }

    private void printResult(Map<Integer, List<String>> map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < map.size(); i++) {
            List<String> list = map.get(i);

            for (String s :
                    list) {
                stringBuilder.append(s + " ");
            }
        }

        System.out.println(stringBuilder);
    }

    static void countSort(List<List<String>> arr) {
        int half = arr.size() / 2;

        List<List<String>> converted = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if(i < half) {
                List<String> newList = Arrays.asList(arr.get(i).get(0), "-");
                converted.add(newList);
                continue;
            }
            converted.add(arr.get(i));
        }

        String text = converted.stream()
                .sorted((CustomComparator::sortByOrder))
                .map(list -> list.get(1))
                .collect(Collectors.joining(" "));

        System.out.println(text);
    }
}

class CustomComparator {
    public static int sortByOrder(List<String> s1, List<String> s2) {
        String s1Order = s1.get(0);
        String s2Order = s2.get(0);

        if(s1Order.length() != s2Order.length()) {
            return s1Order.length() - s2Order.length();
        }

        return Integer.compare(Integer.parseInt(s1Order), Integer.parseInt(s2Order));
    }
}