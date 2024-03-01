package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumOddBinaryNumber {

    public static String maximumOddBinaryNumber(String s) {
        List<Integer> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }

        list.sort(Collections.reverseOrder());
        
        if (!list.isEmpty()) {
            list.add(list.get(0));
            list.remove(0);
        }
        
        return list.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("0101"));
    }
}
