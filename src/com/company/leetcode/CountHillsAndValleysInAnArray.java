package com.company.leetcode;

public class CountHillsAndValleysInAnArray {
    public static int countHillValley(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            int next = i + 1;
            while (next < nums.length && nums[next] == nums[i]) {
                next++;
            }

            if (next < nums.length) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[next]) {
                    count++;
                }
                if (nums[i] < nums[i - 1] && nums[i] < nums[next]) {
                    count++;
                }
            }
        }

        return count;
    }

    public int countHillValley2(int[] nums) {
        int res = 0; // number of peaks and valleys
        int n = nums.length;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == nums[i - 1]) {
                // deduplication
                continue;
            }
            int left = 0; // left side possibly unequal neighboring corresponding state
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] > nums[i]) {
                    left = 1;
                    break;
                } else if (nums[j] < nums[i]) {
                    left = -1;
                    break;
                }
            }
            int right = 0; // right side possibly unequal neighboring corresponding state
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] > nums[i]) {
                    right = 1;
                    break;
                } else if (nums[j] < nums[i]) {
                    right = -1;
                    break;
                }
            }
            if (left == right && left != 0) {
                // at this time, index i is part of a peak or valley.
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2,4,1,1,6,5}));
    }
}
