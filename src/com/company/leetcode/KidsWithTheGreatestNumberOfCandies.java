package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resultList = new ArrayList<>();

        var max = Arrays.stream(candies).boxed().max(Integer::compare).orElse(null);

        for (int item : candies) {
            resultList.add(item + extraCandies >= max);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}
