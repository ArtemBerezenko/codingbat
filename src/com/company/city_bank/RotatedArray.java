package com.company.city_bank;

public class RotatedArray {


//Suppose an array of length n sorted in ascending order is rotated
// between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//
//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//
//[7,6,0,1,2,4,5]
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    public static int findMin(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[mid + 1] < array[mid]) {
                return array[mid + 1];
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {1,2,4,5,6,0}));
    }
}
