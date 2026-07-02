package com.company.leetcode;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));

        int energy = 0;
        for (int[] task : tasks) {
            energy = Math.max(energy + task[0], task[1]);
        }
        return energy;
    }

    public static void main(String[] args) {
        System.out.println(minimumEffort(new int[][]{{1,3},{2,4},{10,11},{10,12},{8,9}}));
    }
}
