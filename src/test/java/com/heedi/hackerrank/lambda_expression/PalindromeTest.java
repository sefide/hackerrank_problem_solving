package com.heedi.hackerrank.lambda_expression;

import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    void test() {
        int a = 8807088;

        boolean isPalindrome1 = isPalindrome1(a);
        System.out.println(a + " is " + (isPalindrome1 ? "PALINDROME" : "NOT PALINDROME"));


        boolean isPalindrome2 = isPalindrome2(a);
        System.out.println(a + " is " + (isPalindrome2 ? "PALINDROME" : "NOT PALINDROME"));

        boolean isPalindrome3 = isPalindrome3(a);
        System.out.println(a + " is " + (isPalindrome3 ? "PALINDROME" : "NOT PALINDROME"));
    }

    // compare
    private boolean isPalindrome1(int a) {
        String s = String.valueOf(a);
        int length = s.length();

        for (int i = 0; i <= Math.sqrt(length); i++) {
            if(s.charAt(i)!= s.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // reverse
    private boolean isPalindrome2(int a) {
        String s = String.valueOf(a);
        int length = s.length();
        String reverse = new StringBuilder(s).reverse().toString();

        for (int i = 0; i <= Math.sqrt(length); i++) {
            if(s.charAt(i)!= reverse.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // simple compare
    private boolean isPalindrome3(int a) {
        return Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }
}
