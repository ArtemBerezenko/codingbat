package com.company.Leetcode;

public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return new int[] {0, 0};
        }

        int start = findStart(nums, target);
        int finish = findFinish(nums, target);

        return new int[] {start, finish};
    }

    private static int findStart(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int start = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            if (nums[mid] == target) {
                start = mid;
            }
        }

        return start;
    }

    private static int findFinish(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int finish = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

            if (nums[mid] == target) {
                finish = mid;
            }
        }

        return finish;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
}
