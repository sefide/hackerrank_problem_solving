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

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
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
                    if (obstacles.contains(new Set(i, c_q))) {
                        return n - i;
                    }
                }
                return n - c_q;
            }
        },
        LEFT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = c_q - 1; i > 0; i--) {
                    if (obstacles.contains(new Set(i, c_q))) {
                        return c_q - i - 1;
                    }
                }
                return c_q - 1;
            }
        },
        TOP_LEFT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = 1; (r_q + i <= n) && (c_q - i > 0); i++) {
                    if (obstacles.contains(new Set(r_q + i, c_q - i))) {
                        return i - 1;
                    }
                }
                return n - r_q;
            }
        },
        TOP_RIGHT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = 1; (i + r_q <= n) && (i + c_q <= n); i++) {
                    if (obstacles.contains(new Set(r_q + i, c_q + i))) {
                        return i - 1;
                    }
                }
                return n - r_q;
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
                for (int i = 1; (r_q - i > 0) && (c_q - i > 0); i++) {
                    if (obstacles.contains(new Set(r_q - i, c_q - i))) {
                        return i - 1;
                    }
                }
                return c_q - 1;
            }
        },
        DOWN_RIGHT {
            @Override
            public int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles) {
                for (int i = 1; (r_q - i > 0) && (c_q + i <= n); i++) {
                    if (obstacles.contains(new Set(r_q - i, c_q + i))) {
                        return i - 1;
                    }
                }
                return n - c_q;
            }
        };

        public abstract int getAttackCount(int n, int r_q, int c_q, List<Set> obstacles);
    }

}
