package com.company.leetcode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (v1, v2) -> Integer.compare(v2[1], v1[1]));

        int result = 0;
        int i = 0;
        for (int[] box : boxTypes) {
            if (box[0] > truckSize) {
                break;
            }
            result += (box[0] * box[1]);
            truckSize -= box[0];
            i++;
        }

        if (i == boxTypes.length) {
            return result;
        }
        int n = boxTypes[i][0];

        while (truckSize > 0 && n > 0) {
            result += boxTypes[i][1];
            truckSize--;
            n--;
        }

        return result;
    }

    public int maximumUnitsSOLUTION(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int unitCount = 0;
        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }

    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][] {{1,3},{2,2},{3,1}}, 4));

    }
}
