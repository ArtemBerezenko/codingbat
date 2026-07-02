package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostPathWithEdgeReversals {
    public static int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];

            graph[x].add(new int[]{y, w});
            graph[y].add(new int[]{x, 2 * w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, 0});

        boolean[] visited = new boolean[n];

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int d = top[0];
            int x = top[1];

            if (x == n - 1) {
                return d;
            }

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            for (int[] neighbor : graph[x]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (d + w < dist[y]) {
                    dist[y] = d + w;
                    queue.offer(new int[] { dist[y], y });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minCost(4, new int[][]{{0,1,3},{3,1,1},{2,3,4},{0,2,2}}));
    }
}
