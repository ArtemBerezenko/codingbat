package com.company.leetcode;

public class GraphValidTree {

    public static class UnionFind {
        int root[];
        int rank[];

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (root[i] == i) {
                return i;
            }
            return root[i] = find(root[i]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];

            if (uf.isConnected(x, y)) {
                return false;
            }

            uf.union(x, y);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
//        System.out.println(validTree(5, new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}));

    }
}
