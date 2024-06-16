package com.company.leetcode;

public class FindTriangularSumOfAnArray {
    public static int triangularSum(int[] nums) {
        int[] tmp = nums;

        while (tmp.length > 1) {
            int[] cur = new int[tmp.length - 1];

            for (int i = 0; i < tmp.length - 1; i++) {
                cur[i] = (tmp[i] + tmp[i+1]) % 10;
            }
            tmp = cur;
        }

        return tmp[0];
    }

    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1,2,3,4,5}));
    }
}
