package com.company.leetcode;

public class RemoveDigitFromNumberToMaximizeResult {
    public static String removeDigit(String number, char digit) {
        String result = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String s = number.substring(0, i) + number.substring(i + 1);
                if (result.compareTo(s) < 0) {
                    result = s;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeDigit("123", '3'));
    }
}
