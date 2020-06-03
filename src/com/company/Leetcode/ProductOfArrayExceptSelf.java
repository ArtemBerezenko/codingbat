package com.company.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//238(Amazon)https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelfMine(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.remove(i);
            result[i] = temp.stream()
                    .reduce(1, Math::multiplyExact);
        }
        return result;
    }

    public static int[] productExceptSelfDivision(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        for (int num : nums) {
            product *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = product / nums[i];
            }
        }
        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        int temp = 1;
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            temp *= nums[j + 1];
            result[j] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,4};
        productExceptSelf(arr);
        int[] arr1 = {1, 0};
        productExceptSelf(arr1);
        int[] arr2 = {1, 1};
        productExceptSelf(arr2);


    }
}
