package com.company.leetcode;

public class CountAndSay {

    public static String countAndSay(int n) {
        return countAndSay(n, "");
    }

    private static String countAndSay(int n, String str) {
        if (n == 1) {
            return str.concat("1");
        } else {
            str = countAndSay(n - 1, str);
            int count = 1;
            StringBuilder newStr = new StringBuilder();
            String ch = "";
            for (int i = 0; i < str.length(); i++) {
                ch = String.valueOf(str.charAt(i));
                if (i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    newStr.append(count).append(ch);
                    count = 1;
                }
            }
            str = newStr.toString();
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(5));

    }
}
