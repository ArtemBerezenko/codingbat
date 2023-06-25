package com.company.Hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = new ArrayList<>(ranked.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList()));
        ranks.add(0);
        List<Integer> results = player.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        int i = 0;
        for (int result : results) {
            for (; i < ranks.size(); i++) {
                if (result >= ranks.get(i)) {
                    resultList.add(i + 1);
                    break;
                }
            }
        }

        return resultList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(climbingLeaderboard(List.of(100, 90, 90, 80, 75, 60), List.of(50, 65, 77, 90, 102)));
    }
}
