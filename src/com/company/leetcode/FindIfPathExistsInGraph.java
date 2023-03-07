package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindIfPathExistsInGraph {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        stack.push(source);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!isVisited[current]) {
                isVisited[current] = true;

                if (current == destination) {
                    return true;
                }

                for (int dest : adjacencyList.get(current)) {
                    if (!isVisited[dest])
                        stack.push(dest);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));

    }
}
