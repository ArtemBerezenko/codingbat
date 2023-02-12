package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return List.of(List.of());
        if (numRows == 1) return List.of(List.of(1));

        List<List<Integer>> list = new ArrayList<>();
        list.add(0, List.of(1));
        list.add(1, List.of(1, 1));

        for (int i = 2; i < numRows; i++) {
            list.add(i, toPascalList(list.get(i - 1)));
        }
        return list;
    }

    public static List<Integer> toPascalList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < list.size(); i++) {
            result.add(list.get(i - 1) + list.get(i));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
