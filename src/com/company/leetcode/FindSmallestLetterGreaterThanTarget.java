package com.company.leetcode;

public class FindSmallestLetterGreaterThanTarget {


    public static char nextGreatestLetterSolution1(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }

    public static char nextGreatestLetterSolution2(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }

    //using binary search
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[low % letters.length];
    }

    public static char nextGreatestLetter2(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        int goal = Character.getNumericValue(target);
        char min = letters[0];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int current = Character.getNumericValue(letters[mid]);
            if (current <= goal) {
                l = mid + 1;
            } else {
                min = letters[mid];
                r = mid;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        System.out.println(nextGreatestLetter2(new char[]{'c','f','j'}, 'd'));
    }

}
