package com.company.Coderbyte;

import java.util.Scanner;

public class SimpleAdding {
        public static int SimpleAdding(int num) {
            if (num == 0) return 0;
            if (num == 1) return 1;
            return num + SimpleAdding(num - 1);
        }

        public static void main (String[] args) {
            // keep this function call here
            Scanner s = new Scanner(System.in);
            System.out.print(SimpleAdding(Integer.parseInt(s.nextLine())));
        }

    }
