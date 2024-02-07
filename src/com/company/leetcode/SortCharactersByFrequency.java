package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c : s.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v + 1);
            map.putIfAbsent(c, 1);
        }
        
        return map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(SortCharactersByFrequency::handle)
                .collect(Collectors.joining());
    }
    
    private static String handle(Map.Entry<Character, Integer> entry) {
        return String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue()));
    }
    

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
}
