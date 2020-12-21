package com.heedi.hackerrank.easy;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ValidUserNameRegularExpressionTest {

    @Test
    void test() throws FileNotFoundException {
        List<String> userNames
                = Arrays.asList("J_liaJuliaJuliaJuliaJuliaJulia", "Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "q1222321", "SDkdlkwdsadsdasdsadasdad_was");
//        List<String> userNames = new ArrayList<>();

//        File file = new File("src/test/java/com/heedi/hackerrank/resources/easy/ValidUserNameInput01.txt");
//
//        //스캐너로 파일 읽기
//        Scanner scan = new Scanner(file);
//        while (scan.hasNextLine()) {
//            userNames.add(scan.nextLine());
//        }
//
//        String[] array = new String[userNames.size()];
//        userNames.toArray(array);

        for (String userName : userNames) {
            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }

    @Test
    void test2() {
        boolean result = "1String".matches("^[0-9]\\D+");
        System.out.println(result);
    }
}

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^[a-zA-Z][a-zA-Z_0-9]{7,29}";
}
