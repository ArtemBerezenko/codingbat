package com.company.leetcode;

public class PeakIndexInAMountainArray {


    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }

    public static int peakIndexInMountainArraySolution(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }


    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArraySolution(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
