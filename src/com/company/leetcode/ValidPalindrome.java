package com.company.leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cint = c;
            if ((cint >= 48 && cint <= 57) || (cint >= 65 && cint <= 90) || (cint >= 97 && cint <= 122)) {
                sb.append(c);
            }
        }
        String resultStr = sb.toString().toLowerCase();

        int l = 0;
        int h = resultStr.length() - 1;

        while (l < h) {
            char left = resultStr.charAt(l++);
            char right = resultStr.charAt(h--);
            if (left != right) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
