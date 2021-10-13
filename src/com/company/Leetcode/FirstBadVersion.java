package com.company.Leetcode;

public class FirstBadVersion {
    static boolean[] versions;

    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int length = 3;
        versions = createVersions(length, 2);
        System.out.println(firstBadVersion(length));
    }

    private static boolean isBadVersion(int version) {
        return versions[version - 1];
    }

    private static boolean[] createVersions(int length, int badVersionIndex) {
        boolean[] versions = new boolean[length];
        for (int i = 0; i < badVersionIndex - 1; i++) {
            versions[i] = false;
        }
        for (int i = badVersionIndex - 1; i < length; i++) {
            versions[i] = true;
        }
        return versions;
    }
}
