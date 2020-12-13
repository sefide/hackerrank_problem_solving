package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingTheLeaderBoardTest {
    @Test
    void test() {
//        List<Integer> ranked = Arrays.asList(100, 90, 90, 80); // 1 2 2 3
//        List<Integer> player = Arrays.asList(70, 80, 105); // 4 3 1
//        List<Integer> ranked = Arrays.asList(100, 90, 90, 80, 75, 60); // 1 2 2 3 4 5
//        List<Integer> player = Arrays.asList(50, 65, 77, 90, 102); // 6 5 4 2 1
        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10); // 1 1 2 3 3 4 5
        List<Integer> player = Arrays.asList(5, 25, 50, 120); // 6 4 2 1
        List<Integer> test = new ArrayList<>();

        List<Integer> result = climbingLeaderBoard(ranked, player);
        System.out.println(result);
    }

    public static List<Integer> climbingLeaderBoard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();

        ranked = ranked.stream()
                .distinct()
                .collect(Collectors.toList());

        Integer[] array = ranked.toArray(new Integer[0]);

        int i = array.length - 1;

        for (int playerScore : player) {
            while (i >= 0) {
                if (playerScore >= array[i]) {
                    i--;
                }
                else {
                    result.add(i + 2);
                    break;
                }
            }
            if (i < 0) {
                result.add(1);
            }
        }

        return result;
    }
}
