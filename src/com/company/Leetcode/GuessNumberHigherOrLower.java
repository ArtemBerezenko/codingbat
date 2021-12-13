package com.company.Leetcode;

public class GuessNumberHigherOrLower {

    static int pick = 6;

    static int guess(int num) {
        if (pick < num) {
            return -1;
        } else if (pick > num) {
            return 1;
        }
        return 0;
    }

    public static int guessNumber(int n) {
        int l = 0;
        int h = n;

        while (l <= n) {
            int mid = l + (h - l) / 2;

            if (guess(mid) == 1) {
                l = mid + 1;
            } else if (guess(mid) == -1) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    public int guessNumberSolution(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

}
