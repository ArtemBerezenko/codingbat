package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestStringWithAGivenNumericValue {
    public static String getSmallestString(int n, int k) {
        String[] alphabet = new String[26];
        int i = 0;
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet[i++] = String.valueOf(ch);
        }

        List<String> resultList = new ArrayList<>();

        k -= n;
        i = 0;
        while (k > 0) {
            int index = Math.min(k, 25);
            resultList.add(alphabet[index]);
            k -= index;
            i++;
        }

        while (n - i > 0) {
            resultList.add(alphabet[0]);
            i++;
        }

        return resultList.stream().sorted().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(5, 73));
    }
}
