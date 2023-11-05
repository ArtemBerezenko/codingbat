package com.company.leetcode;

import java.util.stream.Collectors;

public class MinimizeStringLength {
    
    public static int minimizedStringLength(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
    }

    public static void main(String[] args) {
        System.out.println(minimizedStringLength("dddaaa"));
    }
}
