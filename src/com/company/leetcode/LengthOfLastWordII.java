package com.company.leetcode;

public class LengthOfLastWordII {
    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        
        return str[str.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
