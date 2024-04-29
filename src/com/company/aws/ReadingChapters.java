package com.company.aws;

import java.util.*;

public class ReadingChapters {
    public static int minimumNumberOfPages(List<Integer> pages, int days) {
        int l = 0;
        int h = 10000 * 100000;
        for (int p : pages) {
            l = Math.max(l, p);
        }

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (canFinish(pages, days, mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return canFinish(pages, days, l) ? l : -1;
    }

    private static boolean canFinish(List<Integer> pages, int days, int maxPagesPerDay) {
        int requiredDays = 0;

        for (int i = 0; i < pages.size(); i++) {
            requiredDays += (int) Math.ceil((double) pages.get(i) / maxPagesPerDay); // Calculate days needed for each chapter
        }

        return requiredDays <= days;
    }


    public static int minimumNumberOfPages2(List<Integer> pages, int days) {
        int low = 1;
        int high = 0;
        for (int pageCount : pages) {
            if (pageCount > high) {
                high = pageCount;
            }
        }

        int result = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            int total = totalDays(pages, mid);

            if (total <= days) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private static int totalDays(List<Integer> pages, int numPages) {
        int total = 0;
        for (int pageCount : pages) {
            total += (pageCount + numPages - 1) / numPages;
        }
        return total;
    }




    public static List<Integer> findKthMinimumVulnerability(int k, int m, List<Integer> vulnerability) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        int windowStart = 0;
        for (int i = 0; i < m - 1; i++) {
            countMap.put(vulnerability.get(i), countMap.getOrDefault(vulnerability.get(i), 0) + 1);
        }

        for (int i = m - 1; i < vulnerability.size(); i++) {
            countMap.put(vulnerability.get(i), countMap.getOrDefault(vulnerability.get(i), 0) + 1);

            int currentKth = findKth(countMap, k);
            result.add(currentKth);

            int outElement = vulnerability.get(windowStart++);
            if (countMap.get(outElement) == 1) {
                countMap.remove(outElement);
            } else {
                countMap.put(outElement, countMap.get(outElement) - 1);
            }
        }

        return result;
    }

    private static int findKth(Map<Integer, Integer> map, int k) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count >= k) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(minimumNumberOfPages2(List.of(2, 3, 4, 5), 5));
        System.out.println(findKthMinimumVulnerability(3, 4, List.of(4,2,3,1,1)));

    }
}
