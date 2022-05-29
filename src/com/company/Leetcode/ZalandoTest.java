package com.company.Leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZalandoTest {

    public static int solution(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().distinct().filter(n -> n > 0).collect(Collectors.toList());

        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            num = i + 1;
            if (num != list.get(i)) {
                return num;
            }
        }
        return num + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,8,9,11,12}));
    }
}
