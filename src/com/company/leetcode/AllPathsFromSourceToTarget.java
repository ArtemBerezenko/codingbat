package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();

        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);

        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));

    }
}
