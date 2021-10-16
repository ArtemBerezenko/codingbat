package com.company.Leetcode;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int[] result = new int[nums.length];
        int i = nums.length - 1;

        while (l <= h) {
            int a = nums[l] * nums[l];
            int b = nums[h] * nums[h];
            if (a < b) {
                result[i] = b;
                h--;
            } else {
                result[i] = a;
                l++;
            }
            i--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{-4,-1,0,3,10}));
        System.out.println(sortedSquares(new int[]{-7,-3,2,3,11}));
        System.out.println(sortedSquares(new int[]{-5,-3,-2,-1}));
        System.out.println(sortedSquares(new int[]{-10000,-9999,-7,-5,0,0,10000}));
        System.out.println(sortedSquares(new int[]{-3,0,2}));
          System.out.println(sortedSquares(new int[]{-1,2,2}));
    }
}