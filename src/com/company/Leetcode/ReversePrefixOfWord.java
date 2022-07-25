package com.company.Leetcode;

public class ReversePrefixOfWord {

    public static String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                int l = 0;
                int h = i;

                while (l <= h) {
                    char tmp = chars[l];
                    chars[l] = chars[h];
                    chars[h] = tmp;
                    l++;
                    h--;
                }
                break;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
