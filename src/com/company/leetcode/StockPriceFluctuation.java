package com.company.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPriceFluctuation {
    static class StockPrice {
        Map<Integer, Integer> prices;
        PriorityQueue<Pair> current;
        PriorityQueue<Pair> maximum;
        PriorityQueue<Pair> minimum;

        public StockPrice() {
            prices = new HashMap<>();
            this.current = new PriorityQueue<>(Comparator.comparing(Pair::timestamp).reversed());
            this.maximum = new PriorityQueue<>(Comparator.comparing(Pair::price).reversed());
            this.minimum = new PriorityQueue<>(Comparator.comparing(Pair::price));
        }

        public void update(int timestamp, int price) {
            prices.put(timestamp, price);
            Pair pair = new Pair(timestamp, price);
            current.add(pair);
            maximum.add(pair);
            minimum.add(pair);
        }

        public int current() {
            while (!current.isEmpty()) {
                Pair pair = current.peek();

                if (prices.get(pair.timestamp()) == pair.price()) {
                    return pair.price();
                }

                current.poll();
            }

            throw new IllegalStateException();
        }

        public int maximum() {
            while (!maximum.isEmpty()) {
                Pair pair = maximum.peek();

                if (prices.get(pair.timestamp()) == pair.price()) {
                    return pair.price();
                }

                maximum.poll();
            }

            throw new IllegalStateException();
        }

        public int minimum() {
            while (!minimum.isEmpty()) {
                Pair pair = minimum.peek();

                if (prices.get(pair.timestamp()) == pair.price()) {
                    return pair.price();
                }

                minimum.poll();
            }

            throw new IllegalStateException();
        }
    }

    record Pair(int timestamp, int price) {
    }

    static void main() {
        StockPrice stockPrice = new StockPrice();

        stockPrice.update(1, 10);
        stockPrice.update(2, 5);

        System.out.println(stockPrice.current());  // Expected: 5
        System.out.println(stockPrice.maximum());  // Expected: 10
        System.out.println(stockPrice.minimum());  // Expected: 5

        // Correct an existing timestamp
        stockPrice.update(1, 3);

        System.out.println(stockPrice.maximum());  // Expected: 5
        System.out.println(stockPrice.minimum());  // Expected: 3
        System.out.println(stockPrice.current());  // Expected: 5

        // Add a newer timestamp
        stockPrice.update(4, 2);

        System.out.println(stockPrice.current());  // Expected: 2
        System.out.println(stockPrice.maximum());  // Expected: 5
        System.out.println(stockPrice.minimum());  // Expected: 2

        // Out-of-order timestamp
        stockPrice.update(3, 100);

        System.out.println(stockPrice.current());  // Expected: 2
        System.out.println(stockPrice.maximum());  // Expected: 100
        System.out.println(stockPrice.minimum());  // Expected: 2

        // Correct the maximum price
        stockPrice.update(3, 1);

        System.out.println(stockPrice.maximum());  // Expected: 5
        System.out.println(stockPrice.minimum());  // Expected: 1

        // Correct the latest timestamp
        stockPrice.update(4, 200);

        System.out.println(stockPrice.current());  // Expected: 200
        System.out.println(stockPrice.maximum());  // Expected: 200
        System.out.println(stockPrice.minimum());  // Expected: 1

        // Correct the latest timestamp again
        stockPrice.update(4, 4);

        System.out.println(stockPrice.current());  // Expected: 4
        System.out.println(stockPrice.maximum());  // Expected: 5
        System.out.println(stockPrice.minimum());  // Expected: 1
    }

}
