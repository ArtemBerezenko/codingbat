package com.company.microsoft;

import java.util.Arrays;

public class SmallestPositiveIntegerThatDoesNotOccurInArray {
    public static int solution(int[] A) {
        Arrays.sort(A);
        
        int min = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (min < A[i]) {
                return min;
            }
            min = A[i] + 1 > 0 ? A[i] + 1 : 1;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5}));
    }
}
