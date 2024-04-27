package com.company.leetcode;

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    sb.append(abbr.charAt(j++));
                }
                i += Integer.parseInt(sb.toString());
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }
}
