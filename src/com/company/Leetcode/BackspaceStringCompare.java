package com.company.Leetcode;

public class BackspaceStringCompare {


    public static boolean backspaceCompareTwoPointersSolution(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }


    public static boolean backspaceCompare(String s, String t) {
        String s1 = handleString(s);
        String s2 = handleString(t);
        return s1.equals(s2);
    }

    private static String handleString(String s) {
        String backspace = "#";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            if (!sb.toString().isEmpty() && substring.equals(backspace)) {
                sb.deleteCharAt(sb.length() - 1);
            } else if (!substring.equals(backspace)) {
                sb.append(substring);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        backspaceCompareTwoPointersSolution("ab##", "c#d#");
    }
}
