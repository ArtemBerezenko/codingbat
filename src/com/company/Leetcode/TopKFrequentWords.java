package com.company.Leetcode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            map.merge(words[i], 1, Integer::sum);
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
}
