package com.company.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {

    public static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        
        for (Map.Entry entry : map.entrySet()) {
            if (!map.containsKey(entry.getValue())) {
                return (String) entry.getValue();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(destCity(List.of(List.of("B","C"),List.of("D","B"), List.of("C","A"))));
    }
}
