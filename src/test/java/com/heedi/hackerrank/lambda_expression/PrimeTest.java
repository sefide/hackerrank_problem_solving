package com.heedi.hackerrank.lambda_expression;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class PrimeTest {

    @Test
    void isPrime() {
        int a = 27;

        boolean isPrime1 = isPrime1(a);
        System.out.println(a + " is " + (isPrime1 ? "PRIME" : "NOT PRIME"));

        boolean isPrime2 = isPrime2(a);
        System.out.println(a + " is " + (isPrime2 ? "PRIME" : "NOT PRIME"));
    }

    // 에라토스테네스의 체 ; Sieve of Eratosthenes
    private boolean[] prime;
    private boolean isPrime1(int a) {
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
                for (int j = i; i * j < Math.sqrt(a); j++) {
                    prime[i * j] = true;
                }
            }
        }

        return true;
    }

    // using BigInteger
    private boolean isPrime2(int a) {
        return BigInteger.valueOf(a).isProbablePrime(1);
    }

}
