package com.heedi.hackerrank.java.medium.tag_content_extractor;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * About com.heedi.hackerrank.java.medium.tag_content_extractor
 */
public class TagContentExtractor {

    /* https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
    Pattern Class
    . compile(String regex) : Compiles the given regular expression into a pattern.
    주어진 정규식을 패턴으로 만듦

    . matcher(CharSequence input) : Creates a matcher that will match the given input against this pattern.
    내부 변수로 text = input, parentPattern = complie한 regex 가진 Matcher 반환

    Matcher Class
    . find() : attempts to find the next subsequence of the input sequence that matches the pattern.
    정규식을 기준으로 주어진 문장(text)을 그룹핑하고 정규식에 일치하는 문자열이 다음 순서가 있으면 true 반환, 없으면 false 반환

    .group(int group) : Returns the input subsequence captured by the given group during the previous match operation.
    find 메소드를 통해 생성된 group 배열 내에서 주어진 인덱스의 그룹 문자열을 반환한다.
    find 메소드 실행 전에 해당 메소드를 호출할 경우, IllegalStateException(No match found) 발생
     */

    @Test
    void test() {
//        String string = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String string = "<SA premium>Imtiaz has a secret crush</SA premium>";
        boolean matchFound = false;

        // <(.+)>  start tags
        // . : Any character
        // + : 1개 이상
        // ([^<]+)  all the text in between the HTML start and end tags (group[2]에 저장)
        // ^ : 문장의 시작
        // </\\1>  HTML end brace that corresponds to our previous start brace
        // \1은 group[1]에 저장된 문자열
        Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String stringInTag = matcher.group(1); // SA premium
            String groupingResult = matcher.group(2); // Imtiaz has a secret crush
            System.out.println(groupingResult);
            matchFound = true;
        }
        if (!matchFound) {
            System.out.println("None");
        }
    }

}
