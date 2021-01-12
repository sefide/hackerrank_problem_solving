package com.heedi.hackerrank.java.medium.tag_content_extractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 * Discussions 참조 Solution
 * 자세한 설명은 test.java.com.heedi.hackerrank.java.tag_content_extractor에...
 */
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("숫자 입력");
        int testCases = Integer.parseInt(in.nextLine());
        System.out.println("");
        while (testCases > 0) {
            String line = in.nextLine();

            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }

            testCases--;
        }
    }

}
