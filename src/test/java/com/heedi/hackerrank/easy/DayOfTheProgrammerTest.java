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
        String format = "%02d.%02d.%d";
        int month = 9;
        int day;

        // The transition from the Julian to Gregorian calendar system occurred in 1918
        if(year == 1918) {
            day = 26;
        } else if ((year <= 1917 && year % 4 == 0) || (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            day = 12;
        } else {
            day = 13;
        }

        return String.format(format, day, month, year);
    }
}
