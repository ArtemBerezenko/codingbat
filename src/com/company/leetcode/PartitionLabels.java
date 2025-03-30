package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while ((i = findNextPartitionLength(s = s.substring(i))) != -1) {
            list.add(i);
        }
        return list;
    }

    private static int findNextPartitionLength(String s) {
        if (s.isEmpty()) return -1;
        int l = 0;
        int h = s.length() - 1;
        int max = 0;

        while (l <= max) {
            while (s.charAt(h) != s.charAt(l)) {
                h--;
            }
            if (h > max) {
                max = h;
            }
            l++;
            h = s.length() - 1;
        }
        return max + 1;
    }


    public static List<Integer> partitionLabelsII(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), findLastIndexOfChar(s, i));
        }

        List<Integer> list = new ArrayList<>();
        int prevLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int last = map.get(s.charAt(i));
            if (i == last) {
                list.add(1);
                prevLength += 1;
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (j == last) {
                    int length = j + 1;
                    list.add(length - prevLength);
                    prevLength += (length - prevLength);
                    i = j;
                    break;
                }
                int current = map.get(s.charAt(j));
                if (current > last) {
                    last = current;
                }
            }
        }

        return list;
    }

    private static int findLastIndexOfChar(String str, int l) {
        int r = str.length() - 1;
        while (str.charAt(l) != str.charAt(r)) {
            r--;
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(partitionLabelsII("eaaaabaaec"));
    }
}
