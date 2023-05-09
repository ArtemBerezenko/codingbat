package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(List.of(1));

        for (int i = 1; i <= rowIndex; i++) {
            result.add((int) (result.get(result.size() - 1) * (long) (rowIndex - i + 1) / i));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

}
