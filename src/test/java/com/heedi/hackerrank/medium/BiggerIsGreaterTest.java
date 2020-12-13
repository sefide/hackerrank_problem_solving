package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class BiggerIsGreaterTest {
    private static final String NO_ANSWER = "no answer";
    private static final int MAX = 'z';
    private static final int MIN = 'a';

    @Test
    void test() {

        String w = "bb";
//        System.out.println(biggerIsGreater(w));

//        int[] array = {0, 1, 1, 1, 4};
        char[] chars = w.toCharArray();

        solution(w);
        makeSelf(chars);
//        nextPermutation(chars);
//        System.out.println(String.valueOf(chars));
//        do {  // Must start at lowest permutation
//            System.out.println(Arrays.toString(array));
//        } while (nextPermutation(array));
    }

    private void solution(String S) {
        int s = (int) S.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .count();

        System.out.println(s);
    }


    void makeSelf(char[] arr) {

        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i <= 0) {
            return;
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = (char) temp;

        //reverse
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = (char) temp;
            i++;
            j--;
        }
    }

    // 참고
    boolean nextPermutation(char[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = (char) temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = (char) temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }

    static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();

        int lastIndex = w.length() - 1;

        findBigCharacter(chars, lastIndex);
        int target = result.get("target");

        if (target == -1) {
            return NO_ANSWER;
        }

        int shouldChange = result.get("shouldChange");
        char temp = chars[shouldChange];
        chars[shouldChange] = chars[target];
        chars[target] = temp;

        return String.valueOf(chars);
    }

    private static Map<String, Integer> result = new HashMap<>();

    private static void findBigCharacter(char[] chars, int lastIndex) {
        if (lastIndex == 0) {
            result.put("target", -1);
            result.put("shouldChange", lastIndex);
            return;
        }

        // asz
        // azs
        int size = lastIndex;
        int betterThanMax = 'z';
        int last = chars[lastIndex];

        for (int i = 0; i < size; i++) {
            if (chars[i] < last) {
                lastIndex = i;
                betterThanMax = chars[lastIndex];
            }
        }

        result.put("target", lastIndex);
        result.put("shouldChange", size);

        if (lastIndex == size) {
            findBigCharacter(chars, lastIndex - 1);
        }

    }

}
