package com.company.Tutorial.Threads;

public class SleepMessages {
    public static void main(String[] args)  {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                return;
            }
            System.out.println(importantInfo[i]);
        }
    }
}
