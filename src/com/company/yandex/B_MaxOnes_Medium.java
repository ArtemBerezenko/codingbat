package com.company.yandex;

public class B_MaxOnes_Medium {

    public static int maxOnes(int[] ints) {
        int max = 0;
        int current = 0;
        int lastIndex = -1;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                current++;
            } else {
                current = i - lastIndex -1;
                lastIndex = i;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        /**
         * Дан массив из нулей и единиц. Нужно определить, какой максимальный по длине подинтервал единиц можно получить, удалив ровно один элемент массива.
         * assert(maxOnes({0, 0}) == 0);
         * assert(maxOnes({1, 0}) == 1);
         * assert(maxOnes({0, 1}) == 1);
         * assert(maxOnes({1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1}) == 5);
         * assert(maxOnes({1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}) == 6);
         * Удалять один элемент из массива обязательно.
         * Требуется решение без дополнительной памяти - O(1), и за линейное время - O(N), исходный массив менять нельзя
         */
        System.out.println(maxOnes(new int[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}));
    }
}
