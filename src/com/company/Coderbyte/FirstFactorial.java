package com.company.Coderbyte;

import java.util.Scanner;

public class FirstFactorial {

    public static int FirstFactorial(int num) {
        if (num == 1) return 1;
        return num * FirstFactorial(num - 1);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FirstFactorial(Integer.parseInt(s.nextLine())));
    }

}
