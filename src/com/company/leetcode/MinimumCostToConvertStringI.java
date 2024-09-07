package com.company.leetcode;

import java.util.*;

public class MinimumCostToConvertStringI {
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Create a graph representation of character conversions
        List<List<Pair>> adjacencyList = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Populate the adjacency list with character conversions
        for (int i = 0; i < original.length; i++) {
            adjacencyList.get(original[i] - 'a').add(new Pair(changed[i] - 'a', cost[i]));
        }

        // Calculate shortest paths for all possible character conversions
        int[][] minConversionCosts = new int[26][26];
        for (int i = 0; i < 26; i++) {
            minConversionCosts[i] = dijkstra(i, adjacencyList);
        }

        // Calculate the total cost of converting source to target
        long totalCost = 0;
        int stringLength = source.length();
        for (int i = 0; i < stringLength; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long charConversionCost = minConversionCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (charConversionCost == -1) {
                    return -1; // Conversion not possible
                }
                totalCost += charConversionCost;
            }
        }
        return totalCost;
    }

    // Find minimum conversion costs from a starting character to all other characters
    private static int[] dijkstra(int startChar, List<List<Pair>> adjacencyList) {
        // Priority queue to store characters with their conversion cost, sorted by cost
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(e -> e.val));

        // Initialize the starting character with cost 0
        priorityQueue.add(new Pair(0, startChar));

        // Array to store the minimum conversion cost to each character
        int[] minCosts = new int[26];
        // Initialize all costs to -1 (unreachable)
        Arrays.fill(minCosts, -1);

        while (!priorityQueue.isEmpty()) {
            Pair currentPair = priorityQueue.poll();
            int currentCost = currentPair.key;
            int currentChar = currentPair.val;

            if (minCosts[currentChar] != -1L && minCosts[currentChar] < currentCost) {
                continue;
            }

            // Explore all possible conversions from the current character
            for (Pair conversion : adjacencyList.get(currentChar)) {
                int targetChar = conversion.key;
                int conversionCost = conversion.val;
                int newTotalCost = currentCost + conversionCost;

                // If we found a cheaper conversion, update its cost
                if (minCosts[targetChar] == -1L || newTotalCost < minCosts[targetChar]) {
                    minCosts[targetChar] = newTotalCost;
                    // Add the updated conversion to the queue for further exploration
                    priorityQueue.add(new Pair(newTotalCost, targetChar));
                }
            }
        }
        // Return the array of minimum conversion costs from the starting character to all others
        return minCosts;
    }


    static class Pair {
        int key;
        int val;

        Pair(int key, int cost) {
            this.key = key;
            this.val = cost;
        }

    }

    public static void main(String[] args) {
        System.out.println(minimumCost(
                "abcd",
                "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                new int[]{2, 5, 5, 1, 2, 20}
        ));
    }
}
