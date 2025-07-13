package com.company.leetcode;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;
        int sum = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                sum++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[] {4,7,9}, new int[] {8,2,5,8}));
    }
}
