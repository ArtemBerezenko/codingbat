package com.company.leetcode;

import java.math.BigInteger;

public class AddBinary {

    public static String addBinary(String a, String b) {
        BigInteger sum = new BigInteger(a, 2).add(new BigInteger(b, 2));
        return sum.toString(2);
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
