package com.company.Examples;

import java.util.Scanner;

public class ArrayClassApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrLength = in.nextInt();

        ArrayClass arrayClass = new ArrayClass(arrLength);
        arrayClass.fillArrayRandomNumbers(arrLength);
        arrayClass.display();

        System.out.print("Please, input value: ");
        int newValue = in.nextInt();

        System.out.print("Please, input position: ");
        int position = in.nextInt();

        int[] newArray = arrayClass.insertItem(newValue, position);

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + ", ");
        }
        System.out.println("");
    }

}
