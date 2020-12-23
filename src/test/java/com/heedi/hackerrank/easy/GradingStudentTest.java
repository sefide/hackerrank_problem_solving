package com.heedi.hackerrank.easy;

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
        if(grade < 38) {
            return grade;
        }

        double t = grade / 5.0;
        if(t - (int)(t) > 0.5) {
            return (int) Math.round(t) * 5;
        }
        return grade;
    }
}
