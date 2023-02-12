package com.company.leetcode;

import java.util.*;

public class SmallestStringWithSwaps {

    static class UnionFind {
        private int[] root;
        private int[] rank;

        public UnionFind(int size) {
            this.root = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
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
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());

        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);

            if (!map.containsKey(root)) {
                map.put(root, new ArrayList<>());
            }

            map.get(root).add(i);
        }

        char[] result = new char[s.length()];

        for (List<Integer> indices : map.values()) {
            List<Character> chars = new ArrayList<>();

            for (int idx : indices) {
                chars.add(s.charAt(idx));
            }

            Collections.sort(chars);

            for (int i = 0; i < chars.size(); i++) {
                result[indices.get(i)] = chars.get(i);
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(smallestStringWithSwaps("dcab", List.of(List.of(0, 3), List.of(1, 2))));
    }
}
