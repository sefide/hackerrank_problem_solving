package com.heedi.hackerrank.problem_solving.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingStudentTest {
    @Test
    void test() {
        List<Integer> list = Arrays.asList(73, 67, 38, 33);

        gradingStudents(list);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> results = new ArrayList<>();
        for (int grade : grades) {
            int result = getResult(grade);
            System.out.println(result);
            results.add(result);
        }

        return results;
    }

    private static Integer getResult(int grade) {
        int remainder = grade % 5;

        return grade < 38 || remainder < 3? grade : grade + 5 - (remainder);
    }
}
