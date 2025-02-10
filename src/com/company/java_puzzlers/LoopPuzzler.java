package com.company.java_puzzlers;

public class LoopPuzzler {
    public static int bar() {
        int[] nums = {1, 2, 3, 4};

        int i = 0;

        for (; i < nums.length; i++) {
            i += nums[i];
        }
        return i;
        //Что вернет i?
    }

    public static void main(String[] args) {
        System.out.println(bar());
    }
}
