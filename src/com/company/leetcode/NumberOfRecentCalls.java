package com.company.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {
    static class RecentCounter {
        private Deque<Integer> queue;

        public RecentCounter() {
            this.queue = new LinkedList<>();
        }

        public int ping(int t) {
            int start = t - 3000;
            queue.add(t);

            while (queue.peek() < start) {
                queue.pop();
            }
            return queue.size();
        }
    }

    static void main() {
        RecentCounter counter = new RecentCounter();

        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}
