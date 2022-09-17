package com.company.Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    static class UnionFind {
        private Map<String, String> graph = new HashMap<>();
        private Map<String, Double> ratio = new HashMap<>();

        public String find(String x) {
            if (!graph.containsKey(x)) {
                graph.put(x, x);
                ratio.put(x, 1.0);
                return x;
            }
            double value = ratio.get(x);
            String parent = x;

            while (!graph.get(parent).equals(parent)) {
                parent = graph.get(parent);
                value *= ratio.get(parent);
            }
            graph.put(x, parent);
            ratio.put(x, value);
            return parent;
        }

        public void union(String x, String y, double z) {
            String p1 = find(x);
            String p2 = find(y);

            if (p1.equals(p2)) {
                return;
            }

            double r1 = ratio.get(x);
            double r2 = ratio.get(y);
            graph.put(p2, p1);
            ratio.put(p2, r1 / r2 * z);
        }

        double get(String a, String b) {
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                return -1.0;
            }

            String p1 = find(a);
            String p2 = find(b);

            if (!p1.equals(p2)) {
                return -1.0;
            }

            return ratio.get(b) / ratio.get(a);
        }
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < values.length; i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = uf.get(queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calcEquation(
                List.of(List.of("a", "b"), List.of("b", "c")),
                new double[]{2.0, 3.0},
                List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"))));
    }
}
