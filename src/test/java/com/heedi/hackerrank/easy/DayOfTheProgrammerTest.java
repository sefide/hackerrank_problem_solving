package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */
public class DayOfTheProgrammerTest {

    @Test
    void test() {
        int year = 2017;

        System.out.println(dayOfProgrammer(year));

    }

    static String dayOfProgrammer(int year) {
        String month = "09";
        String day;

        // TODO : 1918년도는 뭔가 다름 .. !! 원인 알아내기
        if ((year <= 1917 && year % 4 == 0) || (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            day = "12";
        } else {
            day = "13";
        }

        String format = "%s.%s.%s";
        return String.format(format, month, day, year);
    }
}
