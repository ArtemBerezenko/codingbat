package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {

    public static int numTilePossibilities(String tiles) {
        Set<String> sequences = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];

        generateSequences(tiles, "", used, sequences);

        return sequences.size() - 1;
    }

    public static void generateSequences(String tiles, String current, boolean[] used, Set<String> sequences) {
        sequences.add(current);

        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                generateSequences(tiles, current + tiles.charAt(i), used, sequences);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }
}
