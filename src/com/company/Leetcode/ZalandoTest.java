package com.company.Leetcode;

import java.util.*;

public class ZalandoTest {

    public static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] < X) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }


    public static int solution2(int[] A) {
        int MAX = 1000000000;
        int counter = 0;
        int previous = 0;
        for (int height : A) {
            if (height > previous) {
                counter += height - previous;
                if (counter > MAX) return -1;
            }
            previous = height;
        }
        return counter;
    }

    public static int solution3(String[] E) {
        Map<Integer, List<Integer>> employees = new HashMap<>();
        int[] days = new int[10];

        int employee = 1;
        for (String str : E) {
            for (int i = 0; i < str.length(); i++) {
                int day = str.charAt(i) - '0';
                if (employees.containsKey(employee)) {
                    employees.get(employee).add(day);
                } else {
                    List<Integer> listDays = new ArrayList<>();
                    listDays.add(day);
                    employees.put(employee, listDays);
                }
                days[day]++;
            }
            employee++;
        }

        List<Integer> selectedDays = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < days.length; i++) {
            max = days[i] > days[max] ? i : max;
        }
        selectedDays.add(max);
        int prevMaxIndex = max;
        max = 0;
        for (int i = 0; i < days.length; i++) {
            max = days[i] > days[max] && i != prevMaxIndex ? i : max;
        }
        selectedDays.add(max);


        int count = 0;
        for (Map.Entry<Integer, List<Integer>> item : employees.entrySet()) {
            Set<Integer> empDays = new HashSet<>(item.getValue());
            for (Integer i : selectedDays) {
                if (empDays.contains(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(solution3(new String[]{"039", "4", "14", "32", "", "34", "7"}));
    }
}
