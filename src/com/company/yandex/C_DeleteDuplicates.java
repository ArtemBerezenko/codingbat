package com.company.yandex;

import java.io.*;

public class C_DeleteDuplicates {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws Exception {
        init();

        int[] ints = bufferedReader.lines().mapToInt(Integer::valueOf).skip(1)
                .distinct()
                .toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }
    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }
}
