package com.company.microsoft.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Tournament {
    public static int[] solution(int[] skills) {
        int[] results = new int[skills.length];

        List<Integer> currentRound = new ArrayList<>();
        for (int i = 0; i < skills.length; i++) {
            currentRound.add(i);
        }

        int round = 1;
        while (currentRound.size() > 1) {
            List<Integer> nextRound = new ArrayList<>();
            for (int i = 0; i < currentRound.size(); i += 2) {
                int player1 = currentRound.get(i);
                int player2 = currentRound.get(i + 1);

                int winner = Math.max(skills[player1], skills[player2]);
                int looser = Math.min(skills[player1], skills[player2]);

                nextRound.add(winner);
                results[looser] = round;

            }
            currentRound = nextRound;
            round++;
        }

        results[currentRound.get(0)] = round - 1;
        return results;
    }

    public static int[] solution2(int[] skills) {
        int[] results = new int[skills.length];
        Map<Integer, Integer> skillToIndexMap = new HashMap<>();

        for (int i = 0; i < skills.length; i++) {
            skillToIndexMap.put(skills[i], i);
        }

        int round = 1;
        List<Integer> players = new ArrayList<>();
        for (int skill : skills) {
            players.add(skill);
        }

        while (players.size() > 1) {
            List<Integer> nextRoundPlayers = new ArrayList<>();
            for (int i = 0; i < players.size(); i += 2) {
                int player1 = players.get(i);
                int player2 = players.get(i + 1);

                int winner = Math.max(player1, player2);
                int looser = Math.min(player1, player2);

                results[skillToIndexMap.get(looser)] = round;
                nextRoundPlayers.add(winner);
            }
            players = nextRoundPlayers;
            round++;
        }
        Integer winner = players.get(0);
        results[skillToIndexMap.get(winner)] = round - 1;

        return results;
    }

    public static void main(String[] args) {
//        System.out.println(solution2(new int[]{4,2,7,3,1,8,6,5}));
//        System.out.println(solution2(new int[]{4,2,1,3}));
        System.out.println(solution2(new int[]{3,4,2,1}));
    }
}
