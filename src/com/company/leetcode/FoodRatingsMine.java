package com.company.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodRatingsMine {
    private Map<String, TreeSet<Food>> cuisineMap = new HashMap<>();

    public FoodRatingsMine(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < cuisines.length; i++) {
            cuisineMap
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>(Comparator.comparing(f -> ((Food) f).rating).thenComparing(f -> ((Food) f).name)))
                    .add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        Map<String, Food> cuisines = new HashMap<>();
        
        for (Map.Entry<String, TreeSet<Food>> map : cuisineMap.entrySet()) {
            Food foo = map.getValue().stream().filter(f -> f.name.equals(food)).findFirst().orElse(null);
            if (foo != null) {
                cuisines.put(map.getKey(), foo);
            }
        }
        
        for (Map.Entry<String, Food> map : cuisines.entrySet()) {
            TreeSet<Food> treeSet = cuisineMap.get(map.getKey());
            treeSet.remove(map.getValue());
            treeSet.add(new Food(map.getValue().name, newRating));
        }
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> treeSet = cuisineMap.get(cuisine);
        int rating = treeSet.last().rating;
        
        return treeSet.stream().filter(f -> f.rating == rating).map(f -> f.name).findFirst().orElse("");    
    }

    public static class Food {
        String name;
        int rating;

        public Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
//        FoodRatings foodRatings = new FoodRatings(
//                new String[]{"cpctxzh", "bryvgjqmj", "wedqhqrmyc", "ee", "lafzximxh", "lojzxfel", "flhs"},
//                new String[]{"wbhdgqphq", "wbhdgqphq", "mxxajogm", "wbhdgqphq", "wbhdgqphq", "mxxajogm", "mxxajogm"},
//                new int[]{15, 5, 7, 16, 16, 10, 13}
//        );
//
//        foodRatings.changeRating("lojzxfel", 1);
//        System.out.println(foodRatings.highestRated("mxxajogm"));
//        System.out.println(foodRatings.highestRated("wbhdgqphq"));
//        System.out.println(foodRatings.highestRated("mxxajogm"));


        FoodRatingsMine foodRatings = new FoodRatingsMine(
                new String[] {"kimchi","miso","sushi","moussaka","ramen","bulgogi"},
                new String[] {"korean","japanese","japanese","greek","japanese","korean"},
                new int[] {9,12,8,15,14,7}
        );

        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi",16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen",16);
        System.out.println(foodRatings.highestRated("japanese"));
    }
}
