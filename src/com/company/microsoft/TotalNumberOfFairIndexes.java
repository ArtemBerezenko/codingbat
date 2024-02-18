package com.company.microsoft;

public class TotalNumberOfFairIndexes {

    public static int solution(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        int length = A.length;
        
        for (int i = 0; i < length; i++) {
            sumA += A[i];
            sumB += B[i];
        }

        int currentA = 0;
        int currentB = 0;
        int result = 0;

        for (int i = 0; i < length - 1; i++) {
            currentA += A[i];
            currentB += B[i];
            
            if (currentA == currentB && sumA - currentA == currentA && sumB - currentB == currentB) {
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(solution(new int[] { 0, 4, -1, 0, 3},new int[] { 0, -2, 5, 0, 3}));
        System.out.println(solution(new int[]{1, 4, 2, -2, 5, 0}, new int[]{7, -2, -2, 2, 5, 0}));
    }

}
