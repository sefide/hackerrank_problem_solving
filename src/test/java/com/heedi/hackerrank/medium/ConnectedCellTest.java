package com.heedi.hackerrank.medium;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedCellTest {

    private int n;
    private int m;

    @Test
    void test() throws FileNotFoundException {
        List<String> test = new ArrayList<>();
        File file = new File("src/test/java/com/heedi/hackerrank/medium/ConnectedCellInput01.txt");
        //스캐너로 파일 읽기

        Scanner scanner = new Scanner(file);
        n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);
        System.out.println(result);
    }

    private int connectedCell(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int size = checkDirection(matrix, i, j);
                max = Math.max(size, max);
            }
        }

        return max;
    }

    private int checkDirection(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return 0;
        } else if (matrix[row][col] == 0) {
            return 0;
        }

        matrix[row][col] = 0;
        int size = 1;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                size += checkDirection(matrix, r, c);
            }
        }

        return size;
    }

}


// i-1, j-1
// i-1, j
// i-1, j+1

// i, j-1
// i, j
// i, j+1

// i+1, j-1
// i+1, j
// i+1, j+1

