package com.heedi.hackerrank.java.medium.implements_interface;

public class MyCalculator implements AdvancedArithmethic {

    @Override
    public int divisor_sum(int n) {
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
