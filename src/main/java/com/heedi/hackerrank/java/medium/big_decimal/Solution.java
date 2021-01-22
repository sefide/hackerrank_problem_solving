package com.heedi.hackerrank.java.medium.big_decimal;

import java.math.BigDecimal;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-bigdecimal/problem
 */
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

        Arrays.sort(s, (o1, o2) -> {
            if(o1 == null || o2 == null) {
                return 0;
            }

            BigDecimal b1 = new BigDecimal(o1);
            BigDecimal b2 = new BigDecimal(o2);

            return b2.compareTo(b1);
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}