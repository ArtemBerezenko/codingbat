package com.company.leetcode;

public class StringToInteger {

    public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int MAX = 2147483647;
        int MIN = -2147483648;
        int result = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (str.startsWith(" ", i) && i < str.length() - 1) {
            i++;
        }
        if (i < str.length()) {
            String s = str.substring(i, i + 1);
            if (isOperand(s) || isDigit(s)) {
                sb.append(s);
            } else {
                return 0;
            }
        }
        i++;
        while (i < str.length() && isDigit(str.substring(i, i + 1)) && !isOperand(str.substring(i, i + 1))) {
            sb.append(str, i, i + 1);
            i++;
        }
        Double bd = null;
        String string = sb.toString().trim();
        if (string.length() > 0) {
            if (string.length() == 1 && isOperand(string)) return 0;
            bd = Double.valueOf(string);
        }
        if (bd != null) {
            result = bd >= MAX ? MAX : bd <= MIN ? MIN : bd.intValue();
        }
        return result;
    }

    private static boolean isDigit(String s) {
        return s.toLowerCase().equals(s.toUpperCase()) && !s.equals(" ");
    }

    private static boolean isOperand(String s) {
        return s.equals("+") || s.equals("-");
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  -+0012a42"));
        System.out.println(myAtoi("  -0012a42"));
        System.out.println(myAtoi("   +0 123"));
        System.out.println(myAtoi("-abc"));
    }
}
