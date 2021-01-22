package com.heedi.hackerrank.java.medium.big_decimal;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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

        List<BigDecimal> bigDecimals = Arrays.stream(s)
                .filter(Objects::nonNull)
                .map(BigDecimal::new)
                .sorted()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            s[i] = bigDecimals.get(i).toString();
        }
        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}