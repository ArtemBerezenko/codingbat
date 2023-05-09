package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        String str1 = modifyStr(s);
        String str2 = modifyStr(t);

        return str1.equals(str2);
    }

    private static String modifyStr(String s) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (!map.containsKey(str)) {
                map.put(str, i);
            }
            sb.append(map.get(str));
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }

}
