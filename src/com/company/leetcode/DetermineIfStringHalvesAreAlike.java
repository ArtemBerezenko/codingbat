package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        List<Character> vowels1 = getVowels(s.substring(0, s.length() / 2));
        List<Character> vowels2 = getVowels(s.substring( s.length() / 2));

        return vowels1.size() == vowels2.size();
    }

    private static List<Character> getVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            if (vowels.contains(c)) {
                list.add(c);
            }
        }
        Collections.sort(list);
        return list;
    }


    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }
    
}
