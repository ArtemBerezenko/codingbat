package com.company.Hackerrank;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayDS {
    private static final int _MAX = 6; // size of matrix
    private static final int _OFFSET = 2; // hourglass width
    private static int matrix[][] = new int[_MAX][_MAX];
    private static int maxHourglass = -63;

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int currentSum = 0;
        int maxSum = 0;
        int totalCount = 0;
        int indexCount = 0;
        int actionNum = 0;
        int count = 1;
        int length = 0;
        int i = 0;
        int j = 0;
        for (; i < arr[i].length; ) {
            if (count == 1 || count == 3) {
                length = 3;
            } else if (count == 2) {
                length = 2;
                j = totalCount + 1;
            }
            for (; j < totalCount + length; j++) {
                currentSum += arr[i][j];
            }
            if (count == 3) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                } else if (actionNum == 0) {
                    maxSum = currentSum;
                }
                actionNum++;
                currentSum = 0;
                totalCount++;
                j = totalCount;
                count = 1;
                if (j >= (arr[j].length / 2) + 1) {
                    if (i == arr[i].length - 1) {
                        break;
                    }
                    indexCount++;
                    i = indexCount;
                    totalCount = 0;
                    j = 0;
                } else {
                    i = indexCount;
                }
            } else {
                count++;
                i++;
                j = totalCount;
            }
        }
        return maxSum;
    }

    static void hurglass(int i, int j) {
        int tmp = 0;

        for (int k = j; k <= j + _OFFSET; k++) {
            tmp += matrix[i][k];
            tmp += matrix[i + _OFFSET][k];
        }

        tmp += matrix[i + 1][j + 1];

        if (maxHourglass < tmp) {
            maxHourglass = tmp;
        }

    }

    static void hurglass8(int[][] arr) {
        for (int i = 0; i < _MAX - _OFFSET; i++) {
            for (int j = 0; j < _MAX - _OFFSET; j++) {
                hurglass(i, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int[][] arr = new int[_MAX][_MAX];

        for (int i = 0; i < _MAX; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < _MAX; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                matrix[i][j] = arrItem;
            }
        }

//        int result = hourglassSum(arr);
//        System.out.println(result);

        for (int i = 0; i < _MAX - _OFFSET; i++) {
            for (int j = 0; j < _MAX - _OFFSET; j++) {
                hurglass(i, j);
            }
        }
        System.out.println(maxHourglass);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
