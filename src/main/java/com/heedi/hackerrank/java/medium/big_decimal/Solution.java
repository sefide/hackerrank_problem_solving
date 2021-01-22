package com.heedi.hackerrank.java.medium.big_decimal;

import java.math.BigDecimal;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        BigDecimal max = new BigDecimal(s[0]);
        int maxIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                BigDecimal b = new BigDecimal(s[j]);
                if (max.compareTo(b) < 0) {
                    max = b;
                    maxIndex = j;
                }

                if (j == n - 1) {
                    String temp = s[i];
                    s[i] = s[maxIndex];
                    s[maxIndex] = temp;

                    max = new BigDecimal(s[i + 1]);
                    maxIndex = i + 1;
                }
            }
        }

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}