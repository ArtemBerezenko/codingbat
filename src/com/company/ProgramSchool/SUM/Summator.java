package com.company.ProgramSchool.SUM;

public class Summator {

    public int sumN(int target) {
        int sum = 0;
        for (int i = 0; i <= target; i++) {
            sum += i;
        }
        return sum;
    }
}
