package com.company.Leetcode;

public class IntegerToEnglishWords {

    private static final String[] tensNames = {
            "",
            " Ten",
            " Twenty",
            " Thirty",
            " Forty",
            " Fifty",
            " Sixty",
            " Seventy",
            " Eighty",
            " Ninety"
    };

    private static final String[] numNames = {
            "",
            " One",
            " Two",
            " Three",
            " Four",
            " Five",
            " Six",
            " Seven",
            " Eight",
            " Nine",
            " Ten",
            " Eleven",
            " Twelve",
            " Thirteen",
            " Fourteen",
            " Fifteen",
            " Sixteen",
            " Seventeen",
            " Eighteen",
            " Nineteen"
    };

    public static String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        String number = String.valueOf(num);
        int length = number.length() / 3;
        int remainder = number.length() % 3;

        if (num == 0) return "Zero";

        if (number.length() <= 3) {
            return digitToString(sb, number).toString().trim();
        }

        for (int i = length; i >= 0; i--) {
            int mod = number.length() % 3;
            int finish = mod != 0 ? mod : 3;
            if (number.length() >= finish) {
                String prev = sb.toString();
                digitToString(sb, number.substring(0, finish));

                if (i == 3) {
                    if (remainder != 0) {
                        sb.append(" Billion");
                    } else {
                        sb.append(" Million");
                    }
                } else if (i == 2 && !prev.equals(sb.toString())) {
                    if (remainder != 0) {
                        sb.append(" Million");
                    } else {
                        sb.append(" Thousand");
                    }
                } else if (i == 1 && !prev.equals(sb.toString())) {
                    if (remainder != 0) {
                        sb.append(" Thousand");
                    }
                }
                number = number.substring(finish);
            }
        }

        return sb.toString().trim();
    }

    private static StringBuilder digitToString(StringBuilder sb, String head) {
        int digit = Integer.parseInt(head);
        String digitStr = String.valueOf(digit);

        if (digitStr.length() == 1) {
            sb.append(numNames[digit]);
            return sb;
        } else if (digitStr.length() == 3) {
            sb.append(numNames[Integer.parseInt(digitStr.substring(0, 1))]);
            sb.append(" Hundred");
            if (digit % 100 != 0) {
                digitToString(sb, digitStr.substring(1));
            }
        } else {
            if (digit < 20) {
                sb.append(numNames[digit]);
                return sb;
            } else {
                sb.append(tensNames[Integer.parseInt(digitStr.substring(0, 1))]);
                digitToString(sb, digitStr.substring(1));
            }
        }
        return sb;
    }


    public static void main(String[] args) {
        //2,147,483,647
        System.out.println(numberToWords(20));//"Twenty"
        System.out.println("Twenty");
        System.out.println(numberToWords(13));//"Thirteen"
        System.out.println("Thirteen");//"Thirteen"
        System.out.println(numberToWords(23));//"Twenty Three"
        System.out.println("Twenty Three");//"Twenty Three"
        System.out.println(numberToWords(123));//"One Hundred Twenty Three"
        System.out.println("One Hundred Twenty Three");//"One Hundred Twenty Three"
        System.out.println(numberToWords(1000));
        System.out.println("One Thousand");
        System.out.println(numberToWords(100000));//"One Hundred Thousand"
        System.out.println("One Hundred Thousand");//"One Hundred Thousand"
        System.out.println(numberToWords(100000000));
        System.out.println("One Hundred Million");
        System.out.println(numberToWords(1000000));//"One Million"
        System.out.println("One Million");//"One Million"
        System.out.println(numberToWords(3200348));
        System.out.println("Three Million Two Hundred Thousand Three Hundred Forty Eight");
        System.out.println(numberToWords(1000010));
        System.out.println("One Million Ten");
        System.out.println(numberToWords(12015));//"Twelve Thousand Fifteen"
        System.out.println("Twelve Thousand Fifteen");//"Twelve Thousand Fifteen"
        System.out.println(numberToWords(123123));//"One Hundred Twenty Three Thousand One Hundred Twenty Three"
        System.out.println("One Hundred Twenty Three Thousand One Hundred Twenty Three");//"One Hundred Twenty Three Thousand One Hundred Twenty Three"
        System.out.println(numberToWords(12345));//"Twelve Thousand Three Hundred Forty Five"
        System.out.println("Twelve Thousand Three Hundred Forty Five");//"Twelve Thousand Three Hundred Forty Five"
        System.out.println(numberToWords(1234567));//"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        System.out.println("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");//"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        System.out.println(numberToWords(1234567891));//"One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
        System.out.println("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One");//"One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
    }
}
