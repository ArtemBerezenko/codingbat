package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfLaserBeamsInBank {
    public static int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (String str : bank) {
            int sum = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).sum();
            if (sum != 0) {
                list.add(sum);
            }
        }

        int result = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            result += list.get(i) * list.get(i + 1);
            
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }
}
