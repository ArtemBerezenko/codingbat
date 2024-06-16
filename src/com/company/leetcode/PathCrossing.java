package com.company.leetcode;


import kotlin.Pair;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
    
    public static boolean isPathCrossing(String path) {
        Map<String, Pair<Integer, Integer>> map = Map.of(
                "N", new Pair<>(1, 0),
                "S", new Pair<>(-1, 0),
                "E", new Pair<>(0, 1),
                "W", new Pair<>(0, -1)
        );

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(0, 0));
        int x = 0;
        int y = 0;
        
        for (Character c : path.toCharArray()) {
            String s = String.valueOf(c);
            Pair<Integer, Integer> pair = map.get(s);
            x += pair.component1();
            y += pair.component2();
            Pair<Integer, Integer> visit = new Pair<>(x, y);

            if (visited.contains(visit)) {
                return true;
            } 
            
            visited.add(visit);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NNSWWEWSSESSWENNW"));
    }
}
