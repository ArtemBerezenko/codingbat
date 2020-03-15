package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanToInteger {

    private static Map<String, Integer> romanDigits = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    public static int romanToInt(String s) {
        int sum = 0;
        List<String> stringList = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            stringList.add(s.substring(i, i + 1));
        }
        for (int i = 0; i < stringList.size(); i++) {
            String str1 = stringList.get(i);
            String str2 = i + 1 <= stringList.size() - 1 ? stringList.get(i + 1) : null;
            int digit = str2 != null ? getIntByRule(str1, str2) : romanDigits.get(str1);
            sum += digit;
        }
        return sum;
    }

    private static int getIntByRule(String s1, String s2) {
        if (s1.equals("I") && (s2.equals("V") || s2.equals("X"))) {
            return -1;
        }
        if (s1.equals("X") && (s2.equals("L") || s2.equals("C"))) {
            return -10;
        }

        if (s1.equals("C") && (s2.equals("D") || s2.equals("M"))) {
            return -100;
        }
        return romanDigits.get(s1);
    }

    public static void main(String[] args) {
//        int result = romanToInt("MCMXCIV");
        System.out.println(romanToInt("LVIII"));
    }
}
