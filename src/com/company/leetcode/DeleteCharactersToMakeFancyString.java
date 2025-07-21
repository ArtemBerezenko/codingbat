package com.company.leetcode;

public class DeleteCharactersToMakeFancyString {
    public static String makeFancyString(String s) {
        var sb = new StringBuilder();

        if (s.length() < 3) {
            return s;
        }

        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("aaabaaaa"));
    }
}
