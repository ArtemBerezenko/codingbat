package com.company.leetcode;

public class CountOfMatchesInTournament {
    public static int numberOfMatches(int n) {
        int sum = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                sum += n / 2;
                n = n / 2;
            } else {
                sum += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
    }
}
