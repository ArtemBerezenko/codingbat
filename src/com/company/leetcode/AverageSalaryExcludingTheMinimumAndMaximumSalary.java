package com.company.leetcode;

import java.util.Arrays;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public static double average(int[] salary) {
        Arrays.sort(salary);

        int sum = 0;

        for (int i = 1; i <= salary.length - 2; i++) {
            sum += salary[i];
        }

        return (double) sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4000,3000,1000,2000}));
    }
}
