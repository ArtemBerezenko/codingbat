package com.company.Hackerrank;

import java.util.Scanner;

public class MakingAnagrams {

    private static final int NUMBER_LETTERS = 26;

    public static int numberNeededWithStringBuilder(String first, String second) {
        int mustDeleted = 0;
        StringBuilder firstStr = new StringBuilder();
        firstStr.append(first);
        StringBuilder secondStr = new StringBuilder();
        secondStr.append(second);
        for (int i = 0; i < first.length(); i++) {
            if (!secondStr.toString().contains(first.substring(i, i + 1))) {
                firstStr.deleteCharAt(firstStr.indexOf(first.substring(i, i + 1)));
                mustDeleted++;
            } else {
                secondStr.deleteCharAt(secondStr.indexOf(first.substring(i, i + 1)));
            }
        }

        for (int i = 0; i < second.length(); i++) {
            if (!firstStr.toString().contains(second.substring(i, i + 1))) {
                secondStr.deleteCharAt(secondStr.indexOf(second.substring(i, i + 1)));
                mustDeleted++;
            } else {
                firstStr.deleteCharAt(firstStr.indexOf(second.substring(i, i + 1)));
            }
        }
        return mustDeleted;
    }

    private static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return -1;
        }
        int delta = 0;
        for (int i = 0; i < array1.length; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }


    public static int[] getCharCount(String s) {
        int[] charCounts = new int[NUMBER_LETTERS];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int) 'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }

    public static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCount(first);
        int[] charCount2 = getCharCount(second);
        return getDelta(charCount1, charCount2);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        //System.out.println(numberNeededWithStringBuilder(a, b));
        System.out.println(numberNeeded(a, b));
    }
}
