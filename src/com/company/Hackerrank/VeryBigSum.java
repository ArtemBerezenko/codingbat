package com.company.Hackerrank;

import java.util.List;

public class VeryBigSum {
    public static long aVeryBigSum(List<Long> ar) {
        return ar.stream().reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(aVeryBigSum(List.of(2L,3L,5L,1L,3L)));
    }
}
