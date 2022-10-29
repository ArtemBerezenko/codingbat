package com.company.java_puzzlers;

//What does the program print? How to repair it?
public class FunSum {

    class Cache {
        static {
            initializeIfNecessary();
        }

        private static int sum;

        public static int getSum() {
            initializeIfNecessary();
            return sum;
        }

        private static boolean initialized = false;

        private static synchronized void initializeIfNecessary() {
            if (!initialized) {
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                initialized = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Cache.getSum());
    }


}
