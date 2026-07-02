package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {
    public static List<String> removeAnagrams(String[] words) {
        List<String> listOfChars = new ArrayList<>();

        for (String s : words) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            listOfChars.add(str);
        }

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!listOfChars.get(i).equals(listOfChars.get(i - 1))) {
                list.add(words[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
    }
}
