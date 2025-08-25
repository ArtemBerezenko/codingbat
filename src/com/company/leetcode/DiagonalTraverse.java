package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        boolean[][] check = new boolean[mat.length][mat[0].length];
        boolean reversed = true;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (!(i == 0 || j == mat[0].length - 1)) {
                    continue;
                }
                if (check[i][j]) {
                    continue;
                }

                int ii = i;
                int jj = j;
                List<Integer> current = new ArrayList<>();
                while (ii < mat.length && jj >= 0) {
                    if (!check[ii][jj]) {
                        current.add(mat[ii][jj]);
                        check[ii][jj] = true;
                    }
                    ii++;
                    jj--;
                }

                if (reversed) {
                    Collections.reverse(current);
                }
                result.addAll(current);
                reversed = !reversed;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
