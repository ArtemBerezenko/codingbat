package com.company.leetcode;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int k = 0;
        while (i < nums.length - 1) {
            if (nums[i] == 0) {
                while (nums[i] == 0 && i < nums.length - 1) {
                    i++;
                }

                int j = i;
                while (j > k) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1] ;
                    nums[j - 1]  = temp;
                    j--;
                }
            } else {
                i++;
            }
            k++;
        }
    }

    public static void moveZeroesSolution(int[] arr) {
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            if (arr[right] == 0)
                right++;
            else
                swap(arr, left++, right++);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    public static void main(String[] args) {
        int[] ints = {0,1,0,3,12};
        moveZeroesSolution(ints);
        display(ints);

        int[] ints2 = {0,0,1};
        moveZeroes(ints2);
        display(ints2);

        int[] ints1 = {2,1};
        moveZeroesSolution(ints1);
        display(ints1);

        int[] ints3 = {0,0};
        moveZeroes(ints3);
        display(ints3);
    }

    private static void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(" ");
    }
}