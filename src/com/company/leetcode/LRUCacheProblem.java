package com.company.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheProblem {

    static class LRUCache {
        private Cache cache;

        public LRUCache(int capacity) {
            this.cache = new Cache(capacity);
        }

        public int get(int key) {
            return cache.get(key);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }


        class Cache extends LinkedHashMap<Integer, Integer> {
            private int capacity;

            public Cache(int initialCapacity) {
                super(initialCapacity, 0.75F, true);
                this.capacity = initialCapacity;
            }

            public int get(int key) {
                return this.getOrDefault(key, -1);
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        }
    }

    static class LRUCache2 {
        private int capacity;
        private Map<Integer, ListNode> dic;
        private ListNode head;
        private ListNode tail;


        public LRUCache2(int capacity) {
            this.capacity = capacity;
            dic = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!dic.containsKey(key)) {
                return -1;
            }

            ListNode node = dic.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (dic.containsKey(key)) {
                ListNode oldNode = dic.get(key);
                remove(oldNode);
            }

            ListNode node = new ListNode(key, value);
            dic.put(key, node);
            add(node);

            if (dic.size() > capacity) {
                ListNode nodeToDelete = head.next;
                remove(nodeToDelete);
                dic.remove(nodeToDelete.key);
            }
        }

        public void add(ListNode node) {
            ListNode previousEnd = tail.prev;
            previousEnd.next = node;
            node.prev = previousEnd;
            node.next = tail;
            tail.prev = node;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }


        class ListNode {
            int key;
            int val;
            ListNode next;
            ListNode prev;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
    }
}
