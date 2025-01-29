package com.company.leetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak_Bottom_Up (String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // Make sure to stay in bounds while checking criteria
                if (i >= word.length() - 1 && (i == word.length() - 1 || dp[i - word.length()])) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }


    private static String s;
    private static List<String> wordDict;
    private static int[] memo;

    private static boolean dp(int i) {
        if (i < 0) return true;

        if (memo[i] == -1) {
            for (String word : wordDict) {
                if (i >= word.length() - 1 && dp(i - word.length())) {
                    if (s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        memo[i] = 1;
                        break;
                    }
                }
            }
        }

        if (memo[i] == -1) {
            memo[i] = 0;
        }

        return memo[i] == 1;
    }

    public static boolean wordBreak_Top_down(String s, List<String> wordDict) {
        WordBreak.s = s;
        WordBreak.wordDict = wordDict;
        WordBreak.memo = new int[s.length()];
        Arrays.fill(WordBreak.memo, -1);
        return dp(s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(wordBreak_Top_down("leetcode", List.of("leet","code")));
    }
}
