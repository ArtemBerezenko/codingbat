package com.company.Coderbyte;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {
    private int x;
    private int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return x == test.x &&
                y == test.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Test test1 = new Test(5, 4);
        Test test2 = new Test(5, 4);
        int has1 = test1.hashCode();
        int has2 = test2.hashCode();
        if (test1.equals(test2)) {
            System.out.println("Yes");
        }

        Set set = new HashSet();
        set.add(test1);
        set.add(test2);
        set.contains(test2);
    }
}
