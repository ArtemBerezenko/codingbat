package com.company.microsoft.third;

public class PiecesDistance {
    public static int solution(int[] board) {
        int[] left = new int[board.length];
        int[] right = new int[board.length];

        for (int i = 0; i < board.length; i++) {
            left[i] = Integer.MAX_VALUE;
            right[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                left[i] = 0;
            } else if (i > 0 && left[i - 1] != Integer.MAX_VALUE) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i] == 0) {
                right[i] = 0;
            } else if (i < board.length - 1 && right[i + 1] != Integer.MAX_VALUE) {
                right[i] = right[i + 1] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 1) {
                int minDist = Math.min(left[i], right[i]);
                if (minDist != Integer.MAX_VALUE) {
                    result += minDist;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 0, 0, 1}));
        System.out.println(solution(new int[]{0, 1}));
        System.out.println(solution(new int[]{0, 0, 0}));

    }
}
