package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EncryptionTest {

    @Test
    void test() {
        String s = "haveaniceday";
        // have anic eday

        System.out.println(encryption(s));
    }

    static String encryption(String s) {
        int root = (int) Math.ceil(Math.sqrt(s.length()));

        System.out.println(root);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < root; i++) {
            StringBuilder t = new StringBuilder();

            for (int j = i; j < s.length(); j = j + root) {
                t.append(s.charAt(j));
            }
            result.add(t.toString());
        }

        return String.join(" ", result);
    }


    @Test
    void name() {
        int[] a = {1,2,3};
        int k = 2;
        int[] queries = {0,1,2};

        int[] result = circularArrayRotation(a,k,queries);
        System.out.println(result);
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        k = k % a.length;
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            if (q - k < 0) {
                result[q] = a[a.length + (q - k)];
                continue;
            }
            result[i] = a[q-k];
        }
        return result;

    }
}
