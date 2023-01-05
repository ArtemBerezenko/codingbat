package com.company.Leetcode;

public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int h = chars.length - 1;

        while (l < h) {
            char left = chars[l];
            char right = chars[h];
            if (left != right) {
                if (isPalindrome(s, l + 1, h)) {
                    return true;
                }
                if (isPalindrome(s, l, h - 1)) {
                    return true;
                }
                return false;
            } else {
                l++;
                h--;
            }

        }
        return true;
    }

    private static boolean isPalindrome(String str, int l, int h) {
        char[] chars = str.toCharArray();

        while (l < h) {
            char left = chars[l];
            char right = chars[h];
            if (left != right) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

        public static void main (String[] args){
            System.out.println(validPalindrome("cbbcc"));
        }
    }
