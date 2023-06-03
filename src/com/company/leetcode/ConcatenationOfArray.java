package com.company.leetcode;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0, j = 0; i < ans.length; i++, j++) {
            if (j == nums.length) {
                j = 0;
            }
            ans[i] = nums[j];
        }
        return ans;
    }

    public static int[] getConcatenationSOLUTION(int[] nums) {
        int[] ans = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getConcatenation(new int[]{1,2,1}));

    }
}
