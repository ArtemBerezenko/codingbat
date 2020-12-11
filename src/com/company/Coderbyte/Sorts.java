package com.company.Coderbyte;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Sorts {

    public int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] >= array[j + 1]) {
                    array = swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                array = swap(array, i, min);
            }
        }
        return array;
    }

    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int temp = array[i];
            int n = i;
            while (n > 0 && array[i - 1] >= temp) {
                array[i] = array[i - 1];
                --n;
            }
            array[n] = temp;
        }
        return array;
    }

    private int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j]= temp;
        return array;
    }

    @Test
    public void test() {
        int[] array = new int[]{1, 22, 3, 43, 52, 36, 17, 28, 39, 410};
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(selectSort(array)));
        System.out.println(Arrays.toString(insertionSort(array)));
    }

}
