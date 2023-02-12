package com.company.Leetcode;

import java.util.*;

public class CoinChange {

    //greedy approach:
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        int index = coins.length - 1;

        List<Integer> list = new ArrayList<>();
        while (amount > 0) {
            if (index < 0) {
                return -1;
            }
            if (amount >= coins[index]) {
                int coin = coins[index];
                list.add(coin);
                amount -= coin;
            } else {
                index--;
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[] {1,2,5}, 11));
        System.out.println(coinChange(new int[] {186,419,83,408}, 6249));
    }

}
