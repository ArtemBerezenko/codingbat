package com.company.Examples;

import java.util.Random;

public class ArrayClass {
    private int[] array;

    public ArrayClass(int length) {
        this.array = new int[length];
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

    public void fillArrayRandomNumbers(int length) {
        Random rand= new Random();

        for (int i = 0; i < length; i++) {
            int number = rand.nextInt(900) + 100;
            array[i] = number;
        }
    }

    public int[] insertItem(int value, int position) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        for (int i = newArray.length - 1; i >= position + 1; i--) {
            newArray[i] = newArray[i - 1];
        }

        newArray[position] = value;
        return newArray;
    }






}

