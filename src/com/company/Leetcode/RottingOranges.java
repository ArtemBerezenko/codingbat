package com.company.Leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//994(Amazon) https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {

        if (grid == null) return -1;
        boolean hasFreshOranges = false;

        int count = -1;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.add(new Pair(i, j));
                if (grid[i][j] == 1) hasFreshOranges = true;
            }
        }

        if (!hasFreshOranges) return 0;

        List<Pair> list;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var v1 = queue.remove();
                if ((list = getFreshOrange(v1, grid)) != null) {
                    for (Pair p : list) {
                        grid[p.x][p.y] = 2;
                        queue.add(p);
                    }
                }
            }
            count++;
        }

        for (int[] item : grid) {
            for (int i = 0; i < grid[0].length; i++) {
                if (item[i] == 1)
                    return -1;
            }
        }

        return count;
    }

    private static List<Pair> getFreshOrange(Pair v, int[][] grid) {
        int x = v.x;
        int y = v.y;

        List<Pair> list = new ArrayList<>();

        if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
            list.add(new Pair(x, y + 1));
        }

        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            list.add(new Pair(x, y - 1));
        }

        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            list.add(new Pair(x + 1, y));
        }

        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            list.add(new Pair(x - 1, y));
        }

        return !list.isEmpty() ? list : null;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] { {1,2,1,1,2,1,1} }));
        System.out.println(orangesRotting(new int[][] { {2,1,1},{1,1,0},{0,1,1} }));
        System.out.println(orangesRotting(new int[][] { {2,1,1},{0,1,1},{1,0,1} }));
    }
}
