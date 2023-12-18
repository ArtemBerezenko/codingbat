package com.company.luxoft;


import java.util.*;

/**
 * Given infinite stream of integers.
 * Using only JDK library implement class which would process those integers
 * and at any moment will be able to provide at most N unique biggest values among all processed.
 * Class interface:
 * 1. N is class constructor argument, immutable.
 * 2. void push(int val) - process integers one-by-one.
 * 3. Collection<Integer> top().
 */
public class Stream {
    private int n;
    private List<Integer> items;

    public Stream(int n) {
        this.n = n;
        this.items = new ArrayList<>();
    }

    public void push(int val) {
        if (items.size() == n) {
            Collections.sort(items);
            if (items.get(0) < val) {
                items.set(0, val);
            }
        } else {
            items.add(val);
        }
    }

    public Collection<Integer> top() {
        return items.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public static void main(String[] args) {
        Stream stream = new Stream(5);

        for (int i = 0; i < 15; i++) {
            stream.push(i);
        }

        System.out.println(stream.top());
    }
}
