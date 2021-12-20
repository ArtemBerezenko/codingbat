package com.company.yandex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class A_JewelryFinder {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String jewelry = r.readLine();
        String stones = r.readLine();

        Set<Character> jSet = jewelry.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());

        char[] jStones = stones.toCharArray();

        int result = 0;
        for (char s : jStones) {
            if (jSet.contains(s)) {
                result++;
            }
        }


        System.out.println(result);
    }
}
