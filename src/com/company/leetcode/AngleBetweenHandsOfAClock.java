package com.company.leetcode;

public class AngleBetweenHandsOfAClock {
//    https://leetcode.com/problems/angle-between-hands-of-a-clock/editorial/
    public static double angleClock(int hour, int minutes) {
        int oneMinAngle = 6;
        int oneHourAngle = 30;

        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
    }
}
