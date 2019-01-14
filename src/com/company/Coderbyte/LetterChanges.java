package com.company.Coderbyte;

import java.util.Scanner;

public class LetterChanges {
    public static String LetterChanges(String str) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbersAndSymbols = "123456789!@#$%^&*()|?.,<>+-/ ".toCharArray();
        char[] vowels = "aeiou".toCharArray();
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            str.substring(i, i + 1).toUpperCase();
            char letter = str.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if (letter == alphabet[j]) {
                    string += alphabet[j + 1];
                }
            }

            for (int k = 0; k < numbersAndSymbols.length; k++) {
                if (letter == numbersAndSymbols[k]) {
                    string += letter;
                }
            }
        }

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            char newLetter = ' ';
            for (int j = 0; j < vowels.length; j++) {
                if (letter == vowels[j]) {
                    newLetter = Character.toUpperCase(letter);
                }
                string.replace(letter, newLetter);
            }

        }

        return string;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterChanges(s.nextLine()));
    }

}
