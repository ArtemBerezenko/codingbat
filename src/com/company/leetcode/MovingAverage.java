package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {
    private List<Integer> list = new ArrayList<>();
    private int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (list.size() == size) {
            list.remove(0);
            list.add(size - 1, val);
        } else {
            list.add(val);
        }
        return (double) list.stream().limit(size).mapToInt(Integer::intValue).sum() / list.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(1);
        System.out.println(movingAverage.next(4)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(0)); // return 5.5 = (1 + 10) / 2
//        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
//        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
        
    }
}
