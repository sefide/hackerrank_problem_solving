package com.heedi.hackerrank.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanUtils {

    public static List<String> getList(String filePath) throws FileNotFoundException {
        List<String> inputs = new ArrayList<>();
        File file = new File(filePath);

        //스캐너로 파일 읽기
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            inputs.add(scan.nextLine());
        }

        String[] array = new String[inputs.size()];
        inputs.toArray(array);

        return inputs;
    }
}
