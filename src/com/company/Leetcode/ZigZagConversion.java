package com.company.Leetcode;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        String[][] arr = new String[numRows][s.length()];
        int count = 0;
        boolean isUp = true;
        for (int i = 0; i < s.length(); i++) {
            if (isUp) {
                arr[count++][i] = s.substring(i, i + 1);
                if (count == numRows) {
                    isUp = false;
                    count--;
                }
            } else {
                arr[--count][i] = s.substring(i, i + 1);
                if (count == 0) {
                    isUp = true;
                    count++;
                }
            }
        }

        for (String[] strings : arr) {
            for (String current : strings) {
                if (current != null) {
                    sb.append(current);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));

    }
}
