package com.company.yandex;

import java.io.BufferedReader;
import java.io.FileReader;

public class B_MaxOnesLine {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));

        int[] ints = r.lines().mapToInt(Integer::valueOf).skip(1).toArray();

        int max = 0;
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        System.out.println(max);
    }
}
