package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"leet","code"}, 'e'));
    }
}
