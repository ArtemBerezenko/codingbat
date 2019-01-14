package com.company;

import java.util.*;
import java.io.*;


class Main {
    public static String LongestWord(String sen) {
        String maxWord = "";
        String currentWord = "";
        for (int i = 0; i < sen.length(); i++) {
            if (!sen.substring(i, i + 1).matches("[^A-Za-z0-9 ]") && !sen.substring(i, i + 1).equals(" ")) {
                currentWord += sen.substring(i, i + 1);
            } else if (currentWord.length() > maxWord.length()) {
                maxWord = currentWord;
                currentWord = "";
            } else {
                currentWord = "";
            }
        }

        if (currentWord.length() > maxWord.length()) {
        maxWord = currentWord;
    }
        return maxWord;
}

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}