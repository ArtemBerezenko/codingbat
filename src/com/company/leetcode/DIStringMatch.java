package com.company.leetcode;

public class DIStringMatch {
    public static int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int l = 0;
        int r = result.length - 1;

        for (int i = 0; i < s.length(); i++){
            String str = String.valueOf(s.charAt(i));
            if (str.equals("I")) {
                result[i] = l++;
            } else {
                result[i] = r--;
            }
        }
        result[s.length()] = l;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(diStringMatch("DDI"));
    }
}
