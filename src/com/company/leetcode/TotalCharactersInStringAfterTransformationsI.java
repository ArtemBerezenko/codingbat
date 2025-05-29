package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TotalCharactersInStringAfterTransformationsI {
    public static int lengthAfterTransformations(String s, int t) {
        Map<Character, Character> map = Map.ofEntries(
                Map.entry('a', 'b'),
                Map.entry('b', 'c'),
                Map.entry('c', 'd'),
                Map.entry('d', 'e'),
                Map.entry('e', 'f'),
                Map.entry('f', 'g'),
                Map.entry('g', 'h'),
                Map.entry('h', 'i'),
                Map.entry('i', 'j'),
                Map.entry('j', 'k'),
                Map.entry('k', 'l'),
                Map.entry('l', 'm'),
                Map.entry('m', 'n'),
                Map.entry('n', 'o'),
                Map.entry('o', 'p'),
                Map.entry('p', 'q'),
                Map.entry('q', 'r'),
                Map.entry('r', 's'),
                Map.entry('s', 't'),
                Map.entry('t', 'u'),
                Map.entry('u', 'v'),
                Map.entry('v', 'w'),
                Map.entry('w', 'x'),
                Map.entry('x', 'y'),
                Map.entry('y', 'z')
        );

        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != 'z') {
                    sb.append(map.get(s.charAt(j)));
                } else {
                    sb.append('a');
                    sb.append('b');
                }
            }
            s = sb.toString();
        }
        return s.length();
    }

    private static final int MOD = 1000000007;

    public static int lengthAfterTransformations2(String s, int t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, (freq.getOrDefault(c, 0) + 1) % MOD);
        }

        for (int i = 0; i < t; i++) {
            Map<Character, Integer> next = new HashMap<>();

            int zCount = freq.getOrDefault('z', 0);
            if (zCount > 0) {
                next.put('a', zCount);
            }

            for (char c = 'a'; c < 'z'; c++) {
                int count = freq.getOrDefault(c, 0);
                if (count == 0) {
                    continue;
                }

                char nc = (char) (c + 1);
                next.put(nc, (next.getOrDefault(nc, 0) + count) % MOD);
            }

            if (zCount > 0) {
                next.put('b', (next.getOrDefault('b', 0) + zCount) % MOD);
            }

            freq = next;
        }

        long ans = 0;
        for (int cnt : freq.values()) {
            ans = (ans + cnt) % MOD;
        }
        return (int) ans;
    }

    public static int lengthAfterTransformationsSOLUTION(String s, int t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            for (int i = 0; i < 26; ++i) {
                if (i == 25) {
                    nxt[0] = (nxt[0] + cnt[i]) % MOD;
                    nxt[1] = (nxt[1] + cnt[i]) % MOD;
                } else {
                    nxt[i + 1] = (nxt[i + 1] + cnt[i]) % MOD;
                }
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformationsSOLUTION("abcyy", 2));
    }
}
