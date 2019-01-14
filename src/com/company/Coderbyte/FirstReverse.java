package com.company.Coderbyte;

import java.util.Scanner;

public class FirstReverse {
    public static String FirstReverse(String str) {
        String string = "";
        for (int i = str.length(); i > 0; i--) {
            string += str.substring(i - 1, i);
        }
        return string;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FirstReverse(s.nextLine()));
    }
}
