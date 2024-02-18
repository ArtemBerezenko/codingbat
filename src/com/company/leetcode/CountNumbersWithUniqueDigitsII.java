package com.company.leetcode;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountNumbersWithUniqueDigitsII {

    public static int numberCount(int a, int b) {
        int count = 0;
        
        for (int i = a; i <= b; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            Set<Character> set = IntStream.range(0, chars.length).mapToObj(j -> chars[j]).collect(Collectors.toSet());
            if (chars.length == set.size()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberCount(1, 20));
    }
}
