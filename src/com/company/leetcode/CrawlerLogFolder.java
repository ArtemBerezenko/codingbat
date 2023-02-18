package com.company.leetcode;

public class CrawlerLogFolder {
    public static int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            count += getCount(logs[i]);
            count = Math.max(count, 0);
        }
        return count;
    }

    private static int getCount(String str) {
        if (str.equals("../")) {
            return -1;
        } else if (str.equals("./")) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new String[] {"./","wz4/","../","mj2/","../","../","ik0/","il7/"}));
    }
}
