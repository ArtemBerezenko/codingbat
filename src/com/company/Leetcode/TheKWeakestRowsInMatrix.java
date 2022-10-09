package com.company.Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInMatrix {

    public static class Row {
        int soldiers;
        int index;

        public Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Queue<Row> heap = new PriorityQueue<>((r1, r2) -> {
            if (r1.soldiers == r2.soldiers) {
                return r2.index - r1.index;
            }
            return r2.soldiers - r1.soldiers;
        });

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[i].length; j++) {
                soldiers += mat[i][j];
            }
            heap.add(new Row(soldiers, i));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            Row row = heap.poll();
            result[i] = row.index;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}}, 3));
    }
}
