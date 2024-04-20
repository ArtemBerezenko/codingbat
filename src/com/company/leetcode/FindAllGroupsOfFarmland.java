package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
    public static int[][] findFarmland(int[][] land) {
        if (land == null || land.length == 0) {
            return null;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    list.add(dfs(land, i, j, new int[] {i, j, i, j}));
                }
            }
        }
        return list.toArray(int[][]::new);
    }

    private static int[] dfs(int[][] land, int x, int y, int[] result) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] == 0) {
            return null;
        }

        result[0] = Math.min(result[0], x);
        result[1] = Math.min(result[1], y);
        result[2] = Math.max(result[2], x);
        result[3] = Math.max(result[3], y);

        land[x][y] = 0;
        dfs(land, x - 1, y, result);
        dfs(land, x + 1, y, result);
        dfs(land, x, y - 1, result);
        dfs(land, x, y + 1, result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findFarmland(new int[][]{{1,0,0}, {0,1,1}, {0,1,1}}));
    }
}
