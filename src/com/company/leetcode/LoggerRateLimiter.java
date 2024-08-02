package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    class Logger {
        private Map<String, Integer> map;

        public Logger() {
            this.map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer previousTimestamp = map.getOrDefault(message, timestamp);
            if (previousTimestamp > timestamp) {
                return false;
            } else {
                map.put(message, timestamp + 10);
                return true;
            }
        }
    }
}
