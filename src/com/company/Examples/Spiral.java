package com.company.Examples;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Spiral {

    private static class Queue<E> {

        private class Element<E> {
            private E data;
            private Element<E> next;

            public Element(E data) {
                this.data = data;
                this.next = null;
            }
        }

        private Element<E> front;
        private Element<E> back;

        public Queue() {
            this.front = null;
            this.back = null;
        }

        public boolean isEmpty() {
            return front == null || back == null;
        }

        public void enqueue(E value) {
            Element<E> newElement = new Element<>(value);

            if (isEmpty()) {
                this.front = newElement;
            } else {
                this.back.next = newElement;
            }

            this.back = newElement;
        }

        public E dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Element<E> head = front;
            this.front = front.next;

            return head.data;
        }

        public E peekFirst() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return front.data;
        }

        public E peekLast() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return back.data;
        }

        public void displayQueue() {
            while (front != null) {
                System.out.print(front.data);
                front = front.next;
            }
            System.out.print("");
        }
    }

    public static void display(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
    }

    public static void displayColumns(String[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j][i]);
            }
            System.out.println("");
        }
    }

    public static void putColumnInQueue(String[][] array, Queue<String> spiralQueue) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                spiralQueue.enqueue(array[j][i]);
            }
        }
    }

    public static void putRowInQueue(String[] array, Queue<String> spiralQueue, int counter) {
        for (int i = counter; i < array.length - counter; i++) {
            spiralQueue.enqueue(array[i]);
        }
    }

    public static void putReverceRowInQueue(String[] array, Queue<String> spiralQueue, int counter) {
        for (int i = array.length - 1 - counter; i >= counter; i--) {
            spiralQueue.enqueue(array[i]);
        }
    }

    public static void putColumnIntoQueue(String[][] array, Queue<String> spiralQueue, int rowNumber, int columnNumber) {
        for (int i = rowNumber + 1; i < array[0].length - rowNumber; i++) {
            spiralQueue.enqueue(array[i][columnNumber]);
        }
    }

    public static void putColumnReverceIntoQueue(String[][] array, Queue<String> spiralQueue, int columnNumber) {
        for (int i = array.length - columnNumber - 2; i >= columnNumber + 1; i--) {
            spiralQueue.enqueue(array[i][columnNumber]);
        }
    }


    public static Queue<String> makeSpiral(String[][] array, Queue<String> spiralQueue, int counter, int numberOfRows) {
        int FIRST_ROW = counter;
        int LAST_ROW = array.length - counter;

        if (numberOfRows == 0) {
            return  spiralQueue;
        } else if (numberOfRows == 1) {
            putRowInQueue(array[FIRST_ROW], spiralQueue, counter);
            return spiralQueue;
        } else if (numberOfRows == 2) {
            putRowInQueue(array[FIRST_ROW], spiralQueue, counter);
            putReverceRowInQueue(array[LAST_ROW - 1], spiralQueue, counter);
            return spiralQueue;
        } else {
            putRowInQueue(array[FIRST_ROW], spiralQueue, counter);
            putColumnIntoQueue(array, spiralQueue, counter, array[counter].length - 1 - counter);
            putReverceRowInQueue(array[LAST_ROW - 1], spiralQueue, counter);
            putColumnReverceIntoQueue(array, spiralQueue, counter);
            if (numberOfRows == 3) {
                numberOfRows = 0;
            } else {
                numberOfRows -= 2;
            }
            counter++;
        }
        return makeSpiral(array, spiralQueue, counter, numberOfRows);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();

        String[][] array = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String expression = in.next();
            for (int j = 0; j < expression.length(); j++) {
                String s = expression.substring(j, j + 1);
                array[i][j] = expression.substring(j, j + 1);
            }
        }
//        display(array);
//        System.out.println("");
//        displayColumns(array);
        Queue<String> spiralQueue = new Queue<>();
        makeSpiral(array, spiralQueue, 0, array.length);
        spiralQueue.displayQueue();
    }
}
