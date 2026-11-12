package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class TimeBasedKeyValueStore {
    static class TimeMap {
        Map<String, List<Pair>> map;

        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Pair> list = map.get(key);

            if (list == null || list.isEmpty()) {
                return "";
            }

            int left = 0;
            int right = list.size() - 1;
            String result = "";

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Pair pair = list.get(mid);

                if (pair.timestamp <= timestamp) {
                    result = pair.value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
    }

    record Pair(String value, Integer timestamp) {
    }

    static void main() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        assertEquals("", timeMap.get("foo", 0));

        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
        assertEquals("bar", timeMap.get("foo", 3));

        timeMap.set("hello", "world", 10);
        timeMap.set("hello", "java", 20);
        timeMap.set("hello", "spring", 30);
        assertEquals("", timeMap.get("hello", 5));
        assertEquals("world", timeMap.get("hello", 10));
        assertEquals("world", timeMap.get("hello", 15));
        assertEquals("java", timeMap.get("hello", 25));
        assertEquals("spring", timeMap.get("hello", 30));
        assertEquals("spring", timeMap.get("hello", 100));
        assertEquals("", timeMap.get("missing", 100));
    }
}
