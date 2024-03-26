package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitInJobScheduling {
    // maximum number of jobs are 50000
    static int[] memo = new int[50001];

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        // marking all values to -1 so that we can differentiate 
        // if we have already calculated the answer or not
        Arrays.fill(memo, -1);

        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        for (int i = 0; i < profit.length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < profit.length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }

        return findMaxProfit(jobs, startTime, profit.length, 0);
    }

    private static int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int length, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == length) {
            return 0;
        }

        // return result directly if it's calculated 
        if (memo[position] != -1) {
            return memo[position];
        }

        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));

        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, length, position + 1),
                jobs.get(position).get(2) + findMaxProfit(jobs, startTime, length, nextIndex));

        // return maximum profit and also store it for future reference (memoization)
        return memo[position] = maxProfit;
    }

    private static int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    }
}
