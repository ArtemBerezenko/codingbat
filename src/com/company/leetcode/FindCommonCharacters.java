package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {

    public static List<String> commonChars(String[] words) {
        Map<String, Integer> resultMap = new HashMap<>();
        Map<String, Integer> currentMap = new HashMap<>();
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                currentMap.computeIfPresent(String.valueOf(str.charAt(i)), (k, v) -> v + 1);
                currentMap.putIfAbsent(String.valueOf(str.charAt(i)), 1);
            }
            List<String> forDeletion = new ArrayList<>();

            if (!resultMap.isEmpty()) {
                for (Map.Entry<String, Integer> entry : currentMap.entrySet()) {
                    if (!resultMap.containsKey(entry.getKey())) {
                        forDeletion.add(entry.getKey());
                    } else {
                        currentMap.put(entry.getKey(), Math.min(resultMap.get(entry.getKey()), entry.getValue()));
                    }
                }
            }

            for (String s : forDeletion) {
                currentMap.remove(s);
            }

            if (currentMap.isEmpty()) {
                return List.of();
            } else {
                resultMap = currentMap;
                currentMap = new HashMap<>();
            }
        }

        List<String> resultList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            int n = entry.getValue();
            while (n-- > 0) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"}));
    }

}
