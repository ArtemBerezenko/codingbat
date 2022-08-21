package com.company.Leetcode;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length() - 1; i++) {
            result += ((int) columnTitle.charAt(i) - 64) * (26 * (i + 1));
        }

        return result + (int) columnTitle.charAt(columnTitle.length() - 1) - 64;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
