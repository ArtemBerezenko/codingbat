package com.company.Coderbyte;

import java.util.Scanner;

public class LetterCapitalize {
    public static String LetterCapitalize(String str) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.substring(i - 1, i).equals(" ")) {
                string.append(str.substring(i, i + 1).toUpperCase());
            } else {
                string.append(str.substring(i, i + 1));
            }
        }
        return String.valueOf(string);

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCapitalize(s.nextLine()));
    }

}
