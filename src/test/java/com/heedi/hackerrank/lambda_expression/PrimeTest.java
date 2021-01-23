package com.heedi.hackerrank.lambda_expression;

import org.junit.jupiter.api.Test;

public class PrimeTest {

    @Test
    void isPrime() {
        int a = 12;

        boolean isPrime = isPrime(a);

        System.out.println(a + " is " + (isPrime ? "PRIME" : "NOT PRIME"));
    }

    private boolean[] prime;
    // 에라토스테네스의 체
    private boolean isPrime(int a) {
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

}
