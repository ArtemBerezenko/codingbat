package com.company.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character c : tasks) {
            map.computeIfPresent(c, (k, v) -> v + 1);
            map.putIfAbsent(c, 1);
        }

        List<Integer> list = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .collect(toList());

        List<Integer> maxValues = list.stream()
                .collect(groupingBy(Function.identity(), TreeMap::new, Collectors.toList()))
                .lastEntry()
                .getValue();
        
        return Math.max((n + 1) * (maxValues.get(0) - 1) + maxValues.size(), tasks.length);
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
    }
}
