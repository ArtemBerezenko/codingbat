package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static int minSteps(String s, String t) {
        List<Character> listS = new ArrayList<>(s.chars().mapToObj(c -> (char) c).toList());
        List<Character> listT =  new ArrayList<>(t.chars().mapToObj(c -> (char) c).toList());
        Map<Character, Integer> mapS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.computeIfPresent(listS.get(i), (k, v) -> v + 1);
            mapS.putIfAbsent(listS.get(i), 1);
        }

        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.computeIfPresent(listT.get(i), (k, v) -> v > 0 ? v - 1 : 0);
        }

        return mapS.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static int minStepsSOLUTION(String s, String t) {

        int[] res = new int[26];
        int steps = 0;

        for(int i = 0; i < s.length(); i++){

            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }

        for(int n: res)
            if(n > 0) steps += n;

        return steps;

    }

    public static void main(String[] args) {
        System.out.println(minSteps( "anagram", "mangaar"));
    }
}
