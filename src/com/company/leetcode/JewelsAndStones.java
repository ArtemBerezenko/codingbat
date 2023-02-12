package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        char[] jewelsArr = jewels.toCharArray();
        Set<Character> jewelSet = IntStream.range(0, jewelsArr.length).mapToObj(i -> jewelsArr[i]).collect(Collectors.toSet());
        char[] stonesArr = stones.toCharArray();
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < stonesArr.length; i++) {
            if (jewelSet.contains(stonesArr[i])) {
                resultMap.computeIfPresent(String.valueOf(stonesArr[i]), (k, v) -> v + 1);
                resultMap.putIfAbsent(String.valueOf(stonesArr[i]), 1);
            }
        }
        return resultMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
