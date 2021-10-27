package com.company.Leetcode;

public class ReverseString {

    public static void reverseString(char[] s) {
        int l = 0;
        int h = s.length - 1;
        while (l < h) {
            char temp = s[h];
            s[h] = s[l];
            s[l] = temp;
            l++;
            h--;
        }
    }

    public static void reverseStringRecursive(char[] s) {
        reverse(s, 0);
    }

    private static void reverse(char[] s, int i) {
        if (i >= s.length / 2) return;
        char temp = s[s.length - 1 - i];
        s[s.length - 1 - i] = s[i];
        s[i] = temp;
        reverse(s, i + 1);
    }

    public static void main(String[] args) {
        char[] c = new char[]{'h','e','z','k','o'};
        reverseStringRecursive(c);
        display(c);
    }

    private static void display(char[] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + ", ");
        }
        System.out.println(' ');
    }
}
//['a','m','a','n','a','P',' ',':','l','a','n','a','c',' ',' ','a',',','n','a','l','p',' ','a',' ',',','n','a','m',' ','A']
//['a','m','a','n','a','P',' ',':','l','a','n','a','c',' ','a',' ',',','n','a','l','p',' ','a',' ',',','n','a','m',' ','A']