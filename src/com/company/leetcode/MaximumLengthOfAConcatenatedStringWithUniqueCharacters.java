package com.company.leetcode;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static int maxLength(List<String> arr) {
        return dfs(arr, 0, "");
    }

    private static int dfs(List<String> strArray, int start, String resultStr) {
        Set<Character> resSet = resultStr.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        if (resultStr.length() != resSet.size()) {
            return 0;
        }
        
        int best = resultStr.length();
        for (int i = start; i < strArray.size(); i++)
            best = Math.max(best, dfs(strArray, i + 1, resultStr + strArray.get(i)));
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(List.of("un","iq","ue")));
    }
}
