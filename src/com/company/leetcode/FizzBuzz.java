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
        return switch (i) {
            case Integer j && j % 3 == 0 && j % 5 == 0 -> "FizzBuzz";
            case Integer j && j % 3 == 0 -> "Fizz";
            case Integer j && j % 5 == 0 -> "Buzz";
            default -> i.toString();
        };
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
    }

}
