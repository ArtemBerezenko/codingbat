package com.company.leetcode;

public class ParkingSystem {
    int bigSize;
    int mediumSize;
    int smallSize;

    public ParkingSystem(int big, int medium, int small) {
        this.bigSize = big;
        this.mediumSize = medium;
        this.smallSize = small;
    }

    public boolean addCar(int carType) {
        if (CarType.BIG.value == carType && bigSize > 0) {
            bigSize--;
            return true;
        }
        if (CarType.MEDIUM.value == carType && mediumSize > 0) {
            mediumSize--;
            return true;
        }
        if (CarType.SMALL.value == carType && smallSize > 0) {
            smallSize--;
            return true;
        }
        return false;
    }

    public enum CarType {
        BIG(1),
        MEDIUM(2),
        SMALL(3);

        public final int value;

        CarType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
