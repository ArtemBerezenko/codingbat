package com.company.raiffeisen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    //[1,3, 25, 47,75,99] 100 => 2,4

    public static List<Integer> findSum(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0;
        int h = arr.length - 1;

        while (l < h) {
            int sum = arr[l] + arr[h];

            if (sum == target) {
                return List.of(l, h);
            } else if (sum < target) {
                l++;
            } else {
                h--;
            }
        }
        return List.of();
    }

    public static List<Integer> findSum2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return List.of(i, map.get(diff));
            }
            map.put(arr[i], i);
        }

        return List.of();
    }

    public static void main(String[] args) {
        System.out.println(findSum(new int[]{1, 3, 150, 25, 47, 75, 99, 6, 66, 50, 7, 10000}, 200));
    }

    //create increment method with get() and compareAndSet() of AtomicInteger

    static AtomicInteger integer = new AtomicInteger(1);

    public static int increment() {
        int value;
        do {
            value = integer.get();
        } while (!integer.compareAndSet(value, value + 1));

        return value;
    }

}
