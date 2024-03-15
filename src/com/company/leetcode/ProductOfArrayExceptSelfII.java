package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelfII {
    public static int[] productExceptSelf(int[] nums) {
        int total = Arrays.stream(nums).boxed().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
        
        int[] result =  new int[nums.length];
        
        int current = 1;
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            } else {
                result[i] = total / nums[i];
                current *= nums[i];
            }
        }
        
        if (zeros.size() == 1) {
            result[zeros.get(0)] = current;
        }
        
        
        return result;
    }

    public static int[] productExceptSelfSolution(int[] nums) {
        int[] answer = new int[nums.length];
        
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        
        int result = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * result;
            result *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelfSolution(new int[]{-1,1,0,-3,3}));
    }
}
