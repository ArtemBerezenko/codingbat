package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {
    public static boolean hasSameDigits(String s) {
        List<Integer> list = new ArrayList<>(s.chars().mapToObj(c -> Integer.parseInt(String.valueOf((char) c))).toList());

        while (list.size() > 2) {
            List<Integer> current = new ArrayList<>(list.size() - 1);
            for (int i = 1; i < list.size(); i++) {
                current.add((list.get(i) + list.get(i - 1)) % 10);
            }
            list = current;
        }


        return list.get(0).equals(list.get(1));
    }

    public static void main(String[] args) {
        System.out.println(hasSameDigits("68594"));
    }
}
