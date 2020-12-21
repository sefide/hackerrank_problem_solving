package com.heedi.hackerrank.easy;

import com.heedi.hackerrank.utils.FileScanUtils;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class ValidUserNameRegularExpressionTest {

    @Test
    void test() throws FileNotFoundException {
//        List<String> userNames
//                = Arrays.asList("J_liaJuliaJuliaJuliaJuliaJulia", "Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "q1222321", "SDkdlkwdsadsdasdsadasdad_was");

        // input 파일 읽어오기
        String filePath = "src/test/java/com/heedi/hackerrank/resources/easy/ValidUserNameInput01.txt";
        List<String> userNames = FileScanUtils.getList(filePath);

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
    /*
        Discussion answer : "^[aA-zZ]\\w{7,29}$"

        \w = [a-zA-Z_0-9] : 영문 소대문자, 숫자, underScore(_) 가능
        [aA-zZ] = [a-zA-Z]
        ^ : 행의 시작
        $ : 행의 끝
        {n, m} : 글자 수 n 이상 m 이
     */

}
