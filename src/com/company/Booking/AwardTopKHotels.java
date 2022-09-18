package com.company.Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class AwardTopKHotels {

    public static List<Integer> awardTopKHotels(String positiveKeywords,
                                                String negativeKeywords,
                                                List<Integer> hotelIds,
                                                List<String> reviews,
                                                int k) {
        List<String> positiveReviewsToken = Arrays.asList(positiveKeywords.split(" "));
        List<String> negativeReviewsToken = Arrays.asList(negativeKeywords.split(" "));
        Map<Integer, Integer> positiveReview = new HashMap<>();
        for (int i = 0; i < reviews.size(); i++) {
            int hotelId = hotelIds.get(i);
            List<String> review = Arrays.asList(reviews.get(i).split(" "));
            int currentPositive = (int) review.stream()
                    .filter(positiveReviewsToken::contains)
                    .count();
            int currentNegative = (int) review.stream()
                    .filter(negativeReviewsToken::contains)
                    .count();
            int total = currentPositive * 3 + currentNegative * -1;
            int previous = positiveReview.getOrDefault(hotelId, 0);
            positiveReview.put(hotelId, previous + total);
        }
        return positiveReview.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    @Test
    void test() {
        List<Integer> actual = awardTopKHotels(
                "breakfast beach city center location metro view staff price",
                "not",
                getHotelIds(),
                getReviews(),
                2);
        Assert.assertEquals(actual, getExpectedIds());
    }

    private static List<Integer> getHotelIds() {
        List<Integer> hotelIds = new ArrayList<>();
        hotelIds.add(1);
        hotelIds.add(2);
        hotelIds.add(1);
        hotelIds.add(1);
        hotelIds.add(2);
        return hotelIds;
    }
    private static List<Integer> getExpectedIds() {
        List<Integer> hotelIds = new ArrayList<>();
        hotelIds.add(2);
        hotelIds.add(1);
        return hotelIds;
    }
    private static List<String> getReviews() {
        List<String> reviews = new ArrayList<>();
        reviews.add("This hotel has a nice view of the city center. The location is perfect.");
        reviews.add("The breakfast is ok. Regarding location, it is quite far from city center but price is cheap so it is worth.");
        reviews.add("Location is excellent, 5 minutes from city center. There is also a metro station very close to the hotel");
        reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
        reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from city center");
        return reviews;
    }
}
