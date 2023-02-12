package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

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


    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
