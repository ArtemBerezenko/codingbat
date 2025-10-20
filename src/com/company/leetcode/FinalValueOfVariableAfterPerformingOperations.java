package com.company.leetcode;

import java.util.Set;

public class FinalValueOfVariableAfterPerformingOperations {
    public static int finalValueAfterOperations(String[] operations) {
        int sum = 0;
        Set<String> addition = Set.of("++X", "X++");
        Set<String> subtraction = Set.of("--X", "X--");

        for (String s : operations) {
            if (addition.contains(s)) {
                sum++;
            }
            if (subtraction.contains(s)) {
                sum--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X","X++","X++"}));
    }
}
