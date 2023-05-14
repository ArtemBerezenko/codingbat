package com.company.leetcode;

public class ShortestWordDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDist = wordsDict.length;
        int i = 0;
        int i1 = -1;
        int i2 = -1;

        for (String str : wordsDict) {
            if (str.equals(word1)) {
                i1 = i;
            } else if (str.equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1) {
                minDist = Math.min(minDist, Math.abs(i1 - i2));
            }
            i++;
        }

        return minDist;
    }

    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
    }
}
