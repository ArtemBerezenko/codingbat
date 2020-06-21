package com.company.Leetcode;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerToRoman {

    private static Map<Integer, String> map = Stream.of(new Object[][]{
            {1, "I"},
            {2, "II"},
            {3, "III"},
            {4, "IV"},
            {5, "V"},
            {6, "VI"},
            {7, "VII"},
            {8, "VIII"},
            {9, "IX"},
            {10, "X"}
    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

    public static String intToRoman(int num) {
        return toRoman(num, getRound(num));
    }

    private static Integer getRound(int num) {
        int round = 1;
        int i = String.valueOf(num).length();
        while (i > 1) {
            round *= 10;
            i--;
        }
        return round;
    }

    private static String toRoman(int num, int round) {
        StringBuilder sb = new StringBuilder();
        int i;
        while (round > 0 && num > 0) {
            if ((i = (num - num % round) / round) != 0) {
                sb.append(getRoman(i, round));
                num %= round;
            } else {
                i = num / 10;
                if (i != 0) {
                    sb.append(getRoman(num / 10, round /= 10));
                    num = num % round;
                }
            }
            round /= 10;
        }

        return sb.toString();
    }

    private static String getRoman(int num, int round) {
        String str = map.get(num);
        if (round == 10) {
            str = str.replace("X", "C");
            str = str.replace("I", "X");
            str = str.replace("V", "L");
        } else if (round == 100) {
            str = str.replace("I", "C");
            str = str.replace("V", "D");
            str = str.replace("X", "M");
        } else if (round == 1000) {
            str = str.replace("I", "M");
        }
        return str;
    }
//Right decision:
    private static String result = "";
    private static int n = 0;

    public static String intToRomanRIGHT(int num) {
        n = num;
        toR(1000,"M");
        toR(900,"CM");
        toR(500,"D");
        toR(400,"CD");
        toR(100,"C");
        toR(90,"XC");
        toR(50,"L");
        toR(40,"XL");
        toR(10,"X");
        toR(9,"IX");
        toR(5,"V");
        toR(4,"IV");
        toR(1,"I");
        return result;
    }
    private static void toR(int divider, String letter){
        if(n >= divider){
            result += letter.repeat(n / divider);
            n = n % divider;
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRomanRIGHT(1011));
        System.out.println(intToRoman(1020));
        System.out.println(intToRoman(1013));
        System.out.println(intToRoman(101));
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(68));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3999));
    }
}
