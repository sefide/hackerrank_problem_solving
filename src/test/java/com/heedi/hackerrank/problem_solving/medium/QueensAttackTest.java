package com.heedi.hackerrank.problem_solving.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueensAttackTest {


    @ParameterizedTest
    @MethodSource("makeInput")
    void test(int n, int k, int r_q, int c_q, int[][] obstacles) {

        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
    }

    private static Stream<Arguments> makeInput() {
        return Stream.of(
                Arguments.of(5, 3, 4, 3, new int[][]{{5, 5}, {4, 2}, {2, 3}}), // 10
                Arguments.of(1, 0, 1, 1, new int[][]{}), // 0
                Arguments.of(4, 0, 4, 4, new int[][]{}) // 9
        );
    }

    // (O(k))
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int rObstacle = -1;
        int lObstacle = -1;
        int tlRObstacle = -1;
        int tlCObstacle = -1;
        int trRObstacle = -1;
        int trCObstacle = -1;
        int tObstacle = -1;
        int dObstacle = -1;
        int dlRObstacle = -1;
        int dlCObstacle = -1;
        int drRObstacle = -1;
        int drCObstacle = -1;

        int count = 0;
        for (int i = 0; i < k; i++) {
            int[] obstacle = obstacles[i];

            int r = obstacle[0];
            int c = obstacle[1];

            // RIGHT
            if ((r == r_q && c > c_q) && (rObstacle == -1 || rObstacle > c)) {
                rObstacle = c;
            }
            // LEFT
            if ((r == r_q && c < c_q) && (lObstacle == -1 || lObstacle < c)) {
                lObstacle = c;
            }

            // TOP LEFT
            if (r - r_q == c_q - c && r > r_q) {
                if (tlRObstacle == -1 || tlRObstacle > r) {
                    tlRObstacle = r;
                    tlCObstacle = c;
                }
            }
            // TOP RIGHT
            if (r - r_q == c - c_q && r > r_q) {
                if (trRObstacle == -1 || trRObstacle > r) {
                    trRObstacle = r;
                    trCObstacle = c;
                }
            }

            // TOP
            if ((r > r_q && c == c_q) && (tObstacle == -1 || tObstacle > r)) {
                tObstacle = r;
            }
            // DOWN
            if ((r < r_q && c == c_q) && (dObstacle == -1 || dObstacle < r)) {
                dObstacle = r;
            }

            // DOWN LEFT
            if (r_q - r == c_q - c && r < r_q) {
                if (dlCObstacle == -1 || dlCObstacle < c) {
                    dlRObstacle = r;
                    dlCObstacle = c;
                }
            }
            // DOWN RIGHT
            if (r_q - r == c - c_q && r < r_q) {
                if (drCObstacle == -1 || drCObstacle < c) {
                    drRObstacle = r;
                    drCObstacle = c;
                }
            }

        }

        count += rObstacle != -1 ? rObstacle - c_q - 1 : n - c_q;
        count += lObstacle != -1 ? c_q - lObstacle - 1 : c_q - 1;

        count += tlRObstacle != -1 ? tlRObstacle - r_q - 1 : Math.min(c_q - 1, n - r_q); // TL
        count += trRObstacle != -1 ? trRObstacle - r_q - 1 : Math.min(n - c_q, n - r_q); // TR

        count += tObstacle != -1 ? tObstacle - r_q - 1 : n - r_q;
        count += dObstacle != -1 ? r_q - dObstacle - 1 : r_q - 1;

        count += dlCObstacle != -1 ? c_q - dlCObstacle - 1 : Math.min(r_q - 1, c_q - 1); // DL
        count += drCObstacle != -1 ? c_q - drCObstacle - 1 : Math.min(r_q - 1, n - c_q); // DR

        return count;
    }

    // 아까워서 못지우겠는 나의 정성어린 비효율 코드 (O(n))
    static int queensAttackTimeOver(int n, int k, int r_q, int c_q, int[][] obstacles) {
        List<Set> obstacleList = Arrays.stream(obstacles)
                .map(obstacle -> new Set(obstacle[0], obstacle[1]))
                .collect(Collectors.toList());

        return Arrays.stream(DirectionType.values())
                .map(directionType -> directionType.getAttackCount(n, r_q, c_q, obstacleList))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static class Set {
        int x;
        int y;

        public Set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Set set = (Set) o;
            return x == set.x &&
                    y == set.y;
        }
    }

    private enum DirectionType {
        RIGHT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = c_q + 1; i <= n; i++) {
                    if (obstacles.contains(new Set(r_q, i))) {
                        return i - c_q - 1;
                    }
                }
                return n - c_q;
            }
        },
        LEFT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = c_q - 1; i > 0; i--) {
                    if (obstacles.contains(new Set(r_q, i))) {
                        return c_q - i - 1;
                    }
                }
                return c_q - 1;
            }
        },
        TOP_LEFT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                int max = 0;
                for (int i = 1; (r_q + i <= n) && (c_q - i > 0); i++) {
                    if (obstacles.contains(new Set(r_q + i, c_q - i))) {
                        return i - 1;
                    }
                    max = i;
                }
                return max;
            }
        },
        TOP_RIGHT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                int max = 0;
                for (int i = 1; (i + r_q <= n) && (i + c_q <= n); i++) {
                    if (obstacles.contains(new Set(r_q + i, c_q + i))) {
                        return i - 1;
                    }
                    max = i;
                }
                return max;
            }
        },
        TOP {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = r_q + 1; i <= n; i++) {
                    if (obstacles.contains(new Set(i, c_q))) {
                        return i - r_q - 1;
                    }
                }
                return n - r_q;
            }
        },
        DOwN {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = r_q - 1; i > 0; i--) {
                    if (obstacles.contains(new Set(i, c_q))) {
                        return r_q - i - 1;
                    }
                }
                return r_q - 1;
            }
        },
        DOWN_LEFT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                int max = 0;
                for (int i = 1; (r_q - i > 0) && (c_q - i > 0); i++) {
                    if (obstacles.contains(new Set(r_q - i, c_q - i))) {
                        return i - 1;
                    }
                    max = i;
                }
                return max;
            }
        },
        DOWN_RIGHT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                int max = 0;
                for (int i = 1; (r_q - i > 0) && (c_q + i <= n); i++) {
                    if (obstacles.contains(new Set(r_q - i, c_q + i))) {
                        return i - 1;
                    }
                    max = i;
                }
                return max;
            }
        };

        public abstract int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles);
    }

}
