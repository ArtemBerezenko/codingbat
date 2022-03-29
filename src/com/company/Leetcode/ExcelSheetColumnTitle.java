package com.company.Leetcode;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        StringBuilder st = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            char a = (char) ((int) 'A' + rem);
            st.insert(0, a);
            columnNumber = columnNumber / 26;
        }
        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

}
