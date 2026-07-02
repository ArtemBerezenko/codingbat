package com.company.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CouponCodeValidator {
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> set = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        Map<String, Integer> priorityMap = Map.of(
                "electronics", 1,
                "grocery", 2,
                "pharmacy", 3,
                "restaurant", 4
        );

        List<Code> resultList = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i] || !isValid(code[i]) || !set.contains(businessLine[i])) {
                continue;
            }

            resultList.add(new Code(code[i], priorityMap.get(businessLine[i])));
        }

        return resultList.stream()
                .sorted(Comparator.comparing(Code::getValue).thenComparing(Code::getCode))
                .map(Code::getCode)
                .toList();
    }

    private static class Code {
        String code;
        int value;

        public Code(String code, int value) {
            this.code = code;
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public int getValue() {
            return value;
        }
    }

    private static boolean isValid(String s) {
        return s != null && s.matches("^[A-Za-z0-9_]+$");
    }

    public static void main(String[] args) {
        System.out.print(validateCoupons(
                new String[]{"GROCERY15","ELECTRONICS_50","DISCOUNT10"},
                new String[] {"grocery","electronics","invalid"},
                new boolean[]{false,true,true}));
    }
}
