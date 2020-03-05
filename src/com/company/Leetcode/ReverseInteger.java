package com.company.Leetcode;

import scala.Int;

import java.util.ArrayList;

public class ReverseInteger {

    public static int reverse1(int x) {
        char[] chars = ("" + x).toCharArray();
        char[] result = new char[chars.length];
        if (chars.length > 1) {
            if (chars[0] == '-') {
                result[0] = '-';
            }
        }
        int j = result[0] == '-' ? 1 : 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == 0 && chars[i] == '-') {
                break;
            }
            result[j++] = chars[i];
        }
        return (Integer.MAX_VALUE >= Long.parseLong(new String(result))
                && Integer.MIN_VALUE <= Long.parseLong(new String(result)))
                ? Integer.parseInt(new String(result))
                : 0;
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(1534236469));
    }
}
