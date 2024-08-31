package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FurthestPointFromOrigin {
    public static int furthestDistanceFromOrigin(String moves) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : moves.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int leftMoves = map.getOrDefault('L', 0);
        int rightMoves = map.getOrDefault('R', 0);
        int missingMoves = map.getOrDefault('_', 0);
        return leftMoves > rightMoves ?
                leftMoves + missingMoves - rightMoves
                : rightMoves + missingMoves - leftMoves;
    }

    public static void main(String[] args) {
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
    }
}
