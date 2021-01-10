package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PairsTest {
    @Test
    void test() {
        int k = 2;
        int[] arr = {1, 5, 3, 4, 2};
        System.out.println(pairs(k, arr));
    }

    static int pairs(int k, int[] arr) {
        Map<Pairs, Integer> result = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, i);
        }

        for (int value : arr) {
            if (map.get(value + k) != null) {
                result.put(new Pairs(value + k, value), 0);
            }
        }
        return result.size();
    }

    private static class Pairs {
        private int x;
        private int y;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pairs pair = (Pairs) o;
            return (x == pair.x && y == pair.y)
                    || (y == pair.x && x == pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
