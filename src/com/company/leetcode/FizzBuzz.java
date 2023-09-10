package com.company.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(FizzBuzz::fizzBuzzz)
                .collect(Collectors.toList());
    }

    private static String fizzBuzzz(Integer i) {
        if (i % 3 == 0 && i % 5 == 0) return  "FizzBuzz";
        if (i % 3 == 0) return "Fizz";
        if (i % 5 == 0) return "Buzz";
        return i.toString();
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
    }

}
