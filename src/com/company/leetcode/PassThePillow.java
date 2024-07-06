package com.company.leetcode;

public class PassThePillow {
    public static int passThePillow(int n, int time) {
        int fullRounds = time / (n - 1);
        int extraTime = time % (n - 1);


        if (fullRounds % 2 == 0) {
            return extraTime + 1;
        } else {
            return n - extraTime;
        }
    }

    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
    }
}
