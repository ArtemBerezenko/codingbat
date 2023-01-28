package com.company.Leetcode;

import java.util.*;

public class FindTargetIndicesAfterSortingArray {
    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> responseList = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                responseList.add(mid);

                while (mid > 0 && nums[mid - 1] == target) {
                    responseList.add(mid - 1);
                    mid--;
                }

                mid = l + (r - l) / 2;
                while (mid != nums.length - 1 && nums[mid + 1] == target) {
                    responseList.add(mid + 1);
                    mid++;
                }
                return responseList.stream().sorted().toList();
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return responseList.stream().sorted().toList();
    }



    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{40,46,62,56,99,64,15,34,15,32,1,61,32,74,77,86,98,48,86,7,74,18,1,48,15,66,12,81,42,93,63,100,4,100,3,55,97,80,1,17,3,98,55,86,48,93,34,47,29,81,42,37,68,1,50,37,69,47,88,80,46,94,73,34,76,1,86,43,30,19,61,80,69,4,88,40,3,88,50,15,47,27,75,72,19,92,13,11,65,22,71,76,45,62,81,61,74,2,5,4}, 61));
    }

}
