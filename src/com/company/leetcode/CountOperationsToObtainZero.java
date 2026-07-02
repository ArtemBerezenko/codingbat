package com.company.leetcode;

public class CountOperationsToObtainZero {
    public static int countOperations(int num1, int num2) {
        int i = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
    }
}
