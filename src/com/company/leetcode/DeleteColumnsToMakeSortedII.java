package com.company.leetcode;

public class DeleteColumnsToMakeSortedII {
    public static int minDeletionSize(String[] strs) {
        int count = 0;
        boolean[] resolved = new boolean[strs.length - 1];

        for (int i = 0; i < strs[0].length(); i++) {
            boolean isDeleted = false;
            for (int j = 1; j < strs.length; j++) {
                if (!resolved[j - 1] && strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    isDeleted = true;
                    break;
                }
            }

            if (isDeleted) {
                count++;
                continue;
            }

            for (int j = 1; j < strs.length; j++) {
                if (!resolved[j - 1] && strs[j].charAt(i) > strs[j - 1].charAt(i)) {
                    resolved[j - 1] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"xc","yb","za"}));
    }
}
