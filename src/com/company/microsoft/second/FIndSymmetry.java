package com.company.microsoft.second;

import java.util.ArrayList;
import java.util.List;

public class FIndSymmetry {

    public static int solution(String[] grid) {
        int N = grid.length;
        int M = grid[0].length();

        // Convert the grid into a char matrix for easier manipulation
        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = grid[i].toCharArray();
        }

        int totalMoves = 0;

        // Count moves for each row
        for (int i = 0; i < N; i++) {
            totalMoves += countMoves(matrix[i]);
        }

        // Count moves for each column
        for (int j = 0; j < M; j++) {
            char[] column = new char[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            totalMoves += countMoves(column);
        }

        return totalMoves;
    }

    // Helper function to count the moves needed to make an array symmetric
    private static int countMoves(char[] arr) {
        int moves = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                moves++;
            }
            left++;
            right--;
        }
        return moves;
    }

    public static int solution2(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        char[][] gridArray = new char[n][m];

        // Convert the grid from String[] to char[][]
        for (int i = 0; i < n; i++) {
            gridArray[i] = grid[i].toCharArray();
        }

        int totalChanges = 0;

        // Calculate changes for rows
        for (int i = 0; i < n; i++) {
            totalChanges += minChangesToPalindrome(gridArray[i]);
        }

        // Calculate changes for columns
        for (int j = 0; j < m; j++) {
            char[] column = new char[n];
            for (int i = 0; i < n; i++) {
                column[i] = gridArray[i][j];
            }
            totalChanges += minChangesToPalindrome(column);
        }

        // Adjust for the overlapping parts that are counted twice
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gridArray[i][j] != gridArray[i][m - j - 1] || gridArray[i][j] != gridArray[n - i - 1][j]) {
                    totalChanges -= 1;
                }
            }
        }

        return totalChanges;
    }

    // Helper method to calculate minimum changes to make a string a palindrome
    private static int minChangesToPalindrome(char[] arr) {
        int changes = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                changes++;
            }
            left++;
            right--;
        }

        return changes;
    }

    public static int solution3(String[] grid) {
        char[][] gridArray = new char[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            gridArray[i] = grid[i].toCharArray();
        }

        int total = 0;

        for (int i = 0; i <= (grid.length - 1) / 2; i++) {
            for (int j = 0; j <= (grid[0].length() - 1) / 2; j++) {
                List<Character> cells = new ArrayList<>();
                cells.add(gridArray[i][j]);

                if (j != grid[0].length() - j - 1) {
                    cells.add(gridArray[i][grid[0].length() - j - 1]);
                }

                if (i != grid.length - i - 1) {
                    cells.add(gridArray[grid.length - i - 1][j]);
                }

                if (i != grid.length - i - 1 && j != grid[0].length() - j - 1) {
                    char cell = gridArray[grid.length - i - 1][grid[0].length() - j - 1];
                    cells.add(cell);
                }

                total += calculateChanges(cells);
            }
        }

        return total;
    }

    private static int calculateChanges(List<Character> cells) {
        int b = 0;
        int w = 0;

        for (char cell : cells) {
            if (cell == 'B') {
                b++;
            } else {
                w++;
            }
        }

        return Math.min(b, w);
    }

    public static void main(String[] args) {
        System.out.println(solution3(new String[] {"BBWWB", "WWWBW", "BWWWW"}));
        System.out.println(solution3(new String[] {"BWB", "WBB", "WBW"}));
        System.out.println(solution3(new String[] {"BBBB", "WWWW", "BBWB", "WWWW"}));

    }
}
