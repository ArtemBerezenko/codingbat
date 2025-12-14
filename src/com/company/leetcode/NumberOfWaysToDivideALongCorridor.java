package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumberOfWaysToDivideALongCorridor {
    private static final int MOD = 1_000_000_007;

    public static int numberOfWays(String corridor) {
        Map<Pair, Integer> cache = new HashMap<>();
        return count(0, 0, corridor, cache);
    }

    private static int count(int i, int count, String corridor, Map<Pair, Integer> cache) {
        if (i == corridor.length()) {
            return count == 2 ? 1 : 0;
        }
        if (cache.containsKey(new Pair(i, count))) {
            return cache.get(new Pair(i, count));
        }

        int currentCount;

        if (count == 2) {
            if (corridor.charAt(i) == 'S') {
                currentCount = count(i + 1, 1, corridor, cache);
            } else {
                currentCount = (count(i + 1, 0, corridor, cache) + count(i + 1, 2, corridor, cache)) % MOD;
            }
        } else {
            if (corridor.charAt(i) == 'S') {
                currentCount = count(i + 1, count + 1, corridor, cache);
            } else {
                currentCount = count(i + 1, count, corridor, cache);
            }
        }

        cache.put(new Pair(i, count), currentCount);
        return currentCount;
    }

    private static class Pair {
        int index;
        int seats;

        public Pair(int index, int seats) {
            this.index = index;
            this.seats = seats;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index && seats == pair.seats;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, seats);
        }
    }

    public static void main(String[] args) {
        System.out.print(numberOfWays("SSPPSPS"));
    }
}
