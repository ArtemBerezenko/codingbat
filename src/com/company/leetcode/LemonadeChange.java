package com.company.leetcode;

public class LemonadeChange {

//    int[] coins = {5, 10, 20};
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five >= 1) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            } else if (bills[i] == 20) {
                twenty++;
                if (ten > 0) {
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return five + ten + twenty > 0;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[] {5,5,10,10,20}));
    }

}
