package com.company.Coderbyte;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

public class Palindrome {

    public boolean palindrome(String s){
        StringBuilder viceVersaStr = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            viceVersaStr.append(s, i, i + 1);
        }
        return s.equals(viceVersaStr.toString());
    }

    public boolean palindrome2(String s){
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public boolean palindrome3(String s){
        StringBuilder viceVersaStr = new StringBuilder(s).reverse();
        return s.equals(viceVersaStr.toString());
    }

    public boolean palindrome4(String s){
        return IntStream.range(0, s.length()).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
    }

    public boolean palindrome5(String s){
        return recursivePalindrome(s,0,s.length() - 1);
    }

    private boolean recursivePalindrome(String s, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if ((s.charAt(forward)) != (s.charAt(backward))) {
            return false;
        }
        if (forward < backward + 1) {
            return recursivePalindrome(s, forward + 1, backward - 1);
        }
        return true;
    }


    @Test
    public void test() {
        Assert.assertTrue(palindrome("radar"));
        Assert.assertFalse(palindrome("away"));
        Assert.assertTrue(palindrome("racecar"));

        Assert.assertTrue(palindrome2("radar"));
        Assert.assertFalse(palindrome2("away"));
        Assert.assertTrue(palindrome2("racecar"));

        Assert.assertTrue(palindrome3("radar"));
        Assert.assertFalse(palindrome3("away"));
        Assert.assertTrue(palindrome3("racecar"));

        Assert.assertTrue(palindrome4("radar"));
        Assert.assertFalse(palindrome4("away"));
        Assert.assertTrue(palindrome4("racecar"));

        Assert.assertTrue(palindrome5("radar"));
        Assert.assertFalse(palindrome5("away"));
        Assert.assertTrue(palindrome5("racecar"));
    }

    public static boolean isPalindrome(String s) {
        return IntStream.range(0, s.length()).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
    }

    private static List<String> palindromeList = new ArrayList<>();

    private static String findLongestPalindrome(String str, int firstIndex) {
        if (firstIndex == str.length() - 1) {
            Optional<String> result = palindromeList.stream().max(Comparator.comparingInt(String::length));
            return result.orElse("");
        } else {
            for (int i = 1; i <= str.length() - firstIndex; i++) {
                String substring = str.substring(firstIndex, firstIndex + i);
                if (isPalindrome(substring)) {
                    palindromeList.add(substring);
                }
            }
            return findLongestPalindrome(str, firstIndex + 1);
        }
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        String h = input.nextLine();
        System.out.println( findLongestPalindrome(h, 0) );
        System.out.println( longestPalindrome(h) );

    }

}
