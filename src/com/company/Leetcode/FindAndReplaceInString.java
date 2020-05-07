package com.company.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {

    public static String findReplaceStringMy(String str, int[] indexes, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (str.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }
        int i = 0;
        while (i < str.length()) {
            if (map.containsKey(i)) {
                result.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                result.append(str, i, i + 1);
                i++;
            }
        }
        return result.toString();
    }

    public static String findReplaceString(String str, int[] indexes, String[] sources, String[] targets) {
        int[] match = new int[str.length()];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (str.startsWith(sources[i], ix))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (match[i] >= 0) {
                ans.append(targets[match[i]]);
                i += sources[match[i]].length();
            } else {
                ans.append(str.charAt(i++));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int[] indexes = {5,2,7};
        String[] sources = {"bn","zzc","wxc"};
        String[] targets = {"t","lwb","nee"};
        System.out.println(findReplaceStringMy("wqzzcbnwxc", indexes, sources, targets));
    }
}
