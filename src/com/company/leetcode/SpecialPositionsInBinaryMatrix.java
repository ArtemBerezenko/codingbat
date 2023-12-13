package com.company.leetcode;

public class SpecialPositionsInBinaryMatrix {
    public static int numSpecial(int[][] mat) {
        int resultCount = 0;
        int[] rows = new int[mat.length];
        int[] columns = new int[mat[0].length];


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                rows[i] += mat[i][j];
            }
        }

        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                columns[i] += mat[j][i];
            }
        }

        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < columns.length; j++){
                if(mat[i][j] == 1 && rows[i] == 1 && columns[j] == 1) {
                    resultCount++;
                }
            }
        }
        
        return resultCount;
    }

    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{0,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}}));
//        System.out.println(numSpecial(new int[][]{{1,0,0}, {0,1,0}, {0,0,1}}));
    }

}
