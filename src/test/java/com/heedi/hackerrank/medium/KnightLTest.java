package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

public class KnightLTest {

    @Test
    void test() {
        int input = 5;

        int[][] result = solution(input);
        System.out.println(Arrays.deepToString(result));
    }

    private int[][] solution(int input) {
        int[][] result = new int[input - 1][input - 1];

        for (int i = 1; i < input; i++) {
            for (int j = i; j < input; j++) {
                int root = findRoot(i, j, input);
                result[i - 1][j - 1] = result[j - 1][i - 1] = root == 0 ? -1 : root - 1;
            }
        }
        return result;
    }

    private int[][] history;

    private int findRoot(int i, int j, int input) {
        history = new int[input][input];

        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(0, 0));
        history[0][0] = 1;

        while (!queue.isEmpty()) {
            Step front = queue.poll();
            List<Step> steps = getMovable(front, i, j, input);
            int value = history[front.getX()][front.getY()];

            for (Step step : steps) {
                if (history[step.getX()][step.getY()] == 0) {
                    history[step.getX()][step.getY()] = value + 1;
                    queue.add(step);
                }
            }

            if (history[input - 1][input - 1] != 0) {
                break;
            }
        }
        return history[input - 1][input - 1];
    }

    private List<Step> getMovable(Step front, int i, int j, int input) {
        List<Step> result = new ArrayList<>();
        int frontX = front.getX();
        int frontY = front.getY();

        // (frontX + i, frontY + j) (frontX - i, frontY + j)
        // (frontX + i, frontY - j) (frontX - i, frontY - j)
        if (frontX + i < input && frontY + j < input) {
            result.add(new Step(frontX + i, frontY + j));
        }
        if (frontX + i < input && frontY - j >= 0) {
            result.add(new Step(frontX + i, frontY - j));
        }
        if (frontX - i >= 0 && frontY + j < input) {
            result.add(new Step(frontX - i, frontY + j));
        }
        if (frontX - i >= 0 && frontY - j >= 0) {
            result.add(new Step(frontX - i, frontY - j));
        }

        // (frontX + j, frontY + i) (frontX - j, frontY + i)
        // (frontX + j, frontY - i) (frontX - j, frontY - i)
        if (frontX + j < input && frontY + i < input) {
            result.add(new Step(frontX + j, frontY + i));
        }
        if (frontX + j < input && frontY - i >= 0) {
            result.add(new Step(frontX + j, frontY - i));
        }
        if (frontX - j >= 0 && frontY + i < input) {
            result.add(new Step(frontX - j, frontY + i));
        }
        if (frontX - j >= 0 && frontY - i >= 0) {
            result.add(new Step(frontX - j, frontY - i));
        }
        return result;
    }

    class Step {
        private int x;
        private int y;

        public Step(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
