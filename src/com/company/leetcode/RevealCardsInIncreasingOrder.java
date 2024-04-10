package com.company.leetcode;

import java.util.*;

public class RevealCardsInIncreasingOrder {
    public static int[] deckRevealedIncreasing(int[] deck) {
        List<Integer> list = new ArrayList<>(Arrays.stream(deck).boxed().sorted().toList());
        Set<Integer> uniques = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>(list);
        
        while (!queue.isEmpty()) {
            uniques.add(queue.poll());
            if (queue.peek() != null && !uniques.contains(queue.peek())) {
                uniques.add(queue.peek());
                queue.add(queue.poll());
            }
        }
        
        return uniques.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static int[] deckRevealedIncreasingSOLUTION(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);

        int[] result = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            result[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(deckRevealedIncreasingSOLUTION(new int[] {17,13,11,2,3,5,7}));
    }
}
