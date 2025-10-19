package com.company.leetcode;

import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int r = triangle.size() - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                int bestBelow = Math.min(triangle.get(r + 1).get(c), triangle.get(r + 1).get(c + 1));
                triangle.get(r).set(c, bestBelow + triangle.get(r).get(c));
            }
        }
        return triangle.getFirst().getFirst();
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6,5,7), List.of(4,1,8,3))));
    }
}
