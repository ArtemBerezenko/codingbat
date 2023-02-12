package com.company.leetcode;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l = 0;
        int h = numbers.length - 1;

        while (l < h) {
            int m =  l + ((h - l) / 2);
            if (numbers[m] < target) {
                if (findSum(numbers, target, result, m))
                    break;
                l = m + 1;
            } else {
                if (findSum(numbers, target, result, m))
                    break;
                h = m - 1;
            }
        }

        if (result[1] == 0) {
            findSum(numbers, target, result, numbers.length - 1);
        }

        return result;
    }

    private static boolean findSum(int[] numbers, int target, int[] result, int m) {
        int i = 0;
        int j = m;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return true;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        display(twoSum(new int[]{-1, 0}, -1));
    }

    private static void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(" ");
    }
}
