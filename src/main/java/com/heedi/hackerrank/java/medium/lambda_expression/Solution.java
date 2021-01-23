package com.heedi.hackerrank.java.medium.lambda_expression;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-lambda-expressions/problem
 */
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here
    public PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        return this::judgePrime;
    }

    private boolean[] prime;
    // 에라토스테네스의 체
    private boolean judgePrime(int a) {
        if (a < 2) {
            return true;
        }

        prime = new boolean[a + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (prime[i]) {
                continue;
            }

            if (a % i == 0) {
                prime[i] = false;
                return false;
            } else {
                for (int j = i * i; j < prime.length; j++) {
                    prime[j] = true;
                }
            }
        }

        return true;
    }

    public PerformOperation isPalindrome() {
        return null;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

