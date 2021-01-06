package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
public class DesignerPDFViewerTest {

    @Test
    void test() {
        String[] hString = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7".split(" ");
        List<Integer> h = Arrays.stream(hString)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String word = "zaba";
        System.out.println(designerPdfViewer(h, word));
    }

    static int designerPdfViewer(List<Integer> h, String word) {
        int width = word.length();

        int height = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            height = Math.max(h.get(index), height);
        }

        return width * height;
    }
}
