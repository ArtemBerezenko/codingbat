package com.company.Geeksforgeeks;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main (String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number = Integer.parseInt(br.readLine());
            while (number > 0) {
                String str = br.readLine();
                System.out.println("");
                System.out.println(checkIsPalindrome(isPalindrome(str)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isPalindrome(String string) {
        boolean isPalindrome = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                stringBuilder.append(string.substring(i, i + 1).toLowerCase());
            }
        }
        for (int i = 0; i < stringBuilder.length() / 2; i++) {
            int j = stringBuilder.length() - (1 + i);

            while (j > stringBuilder.length() / 2) {
                String strFromStart = stringBuilder.substring(i, i + 1);
                String strFromEnd = stringBuilder.substring(j, j + 1);
                if (strFromStart.equals(strFromEnd)) {
                    isPalindrome = true;
                    break;
                } else {
                    return false;
                }
            }
        }
        return isPalindrome;
    }

    public static String checkIsPalindrome(Boolean isPalindrome) {
        if (isPalindrome) return "YES";
        return "NO";
    }

    @Test
    public void testStringX() {
        Boolean isPalindrome = isPalindrome("I am :IronnorI Ma, i");
        System.out.println(isPalindrome);
        Boolean isPalindrome1 = isPalindrome("Ab?/Ba");
        System.out.println(isPalindrome1);
    }
}
