package com.company.leetcode;

public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] targetArr = null;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[0].length - 1]) {
                targetArr = matrix[i];
                break;
            }
        }

        if (targetArr == null) {
            return false;
        }

        int l = 0;
        int h = targetArr.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (targetArr[mid] > target) {
                h = mid - 1;
            } else if (targetArr[mid] < target) {
                l = mid + 1;
            } else if (targetArr[mid] == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrix(new int[][] {{1}}, 0));

    }
}
