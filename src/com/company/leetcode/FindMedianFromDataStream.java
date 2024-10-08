package com.company.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    static class MedianFinder {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (!maxHeap.isEmpty() && maxHeap.peek() >= num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() < maxHeap.size()) {
                return maxHeap.peek();
            } else if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            } else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());
    }
}
