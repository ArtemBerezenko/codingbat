package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpsToReachEndViaPrimeTeleportation {
    public static int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> byPrime = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int p : primeFactors(nums[i])) {
                byPrime.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();

        queue.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int i = queue.poll();

                if (i == n - 1) {
                    return jumps;
                }

                if (i > 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    queue.offer(i - 1);
                }

                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    queue.offer(i + 1);
                }

                int value = nums[i];

                if (isPrime(value) && usedPrime.add(value)) {
                    for (int next : byPrime.getOrDefault(value, Collections.emptyList())) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int d = 3; d <= n / d; d += 2) {
            if (n % d == 0) return false;
        }

        return true;
    }

    private static List<Integer> primeFactors(int x) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                factors.add(i);

                while (x % i == 0) {
                    x /= i;
                }
            }
        }

        if (x > 1) {
            factors.add(x);
        }

        return factors;
    }

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 2, 4, 6}));
    }
}
