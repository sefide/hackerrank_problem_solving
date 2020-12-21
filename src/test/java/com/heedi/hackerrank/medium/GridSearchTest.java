package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GridSearchTest {

    static String[] G;
    static String[] P;

    @Test
    void test() throws FileNotFoundException {
        List<String> test = new ArrayList<>();
        File file = new File("src/test/java/com/heedi/hackerrank/resources/medium/GridSearchInput01.txt");
        //스캐너로 파일 읽기
        Scanner scanner = new Scanner(file);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            System.out.println(gridSearch(G, P));

        }

    }

    static String gridSearch(String[] G, String[] P) {
        int patternIndex = 0;
        boolean next = false;

        for (int i = 0; i < G.length; i++) {
            int startIndex = 0;
            int position = 0;
            if(next) break;
            while(position != -1) {
                position = G[i].indexOf(P[patternIndex], startIndex);

                if(position != -1){
                    next = findNextLine(true, position, i + 1,patternIndex + 1, startIndex);
                }

                if(next) {
                    break;
                }
                startIndex = position + 1;
            }
        }

        return next ? "YES" : "NO";
    }

    private static boolean findNextLine(boolean state, int position, int i, int patternIndex, int startIndex) {
        if(patternIndex >= P.length) {
            return state;
        }
        if(i >= G.length) {
            return state;
        }
        if(!state) {
            return state;
        }

        if(G[i].indexOf(P[patternIndex], startIndex) == position) {
            state = findNextLine(state, position, i + 1, patternIndex + 1, startIndex);
        } else {
            state = false;
        }

        return state;
    }
}
