package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteColumnsToMakeSorted {
    public static int minDeletionSize(String[] strs) {
        List<char[]> columns = new ArrayList<>();

        for (int i = 0; i < strs[0].length(); i++) {
            columns.add(new char[strs.length]);
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                columns.get(i)[j] = strs[j].charAt(i);
            }
        }

        int count = 0;

        for (char[] chars : columns) {
            char[] temp = new String(chars).toCharArray();
            Arrays.sort(temp);
            if (!new String(temp).equals(new String(chars))){
                count++;
            }
        }

        return count;
    }

    public static int minDeletionSize2(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize2(new String[]{"abc", "bce", "cae"}));
    }
}
