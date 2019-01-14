package com.company.Tutorial.Recursion;

class RecursionPrintInOutExplanation {
    private static int depth = 0;
    public static void main(String[] args) {
        f(1);
    }
    public static void f(int x) {
        in(x);
        if (check(x)) {
            f(2 * x);
        }
        out(x);
    }
    public static boolean check(int x) {
        spaces();
        System.out.println("(x < 15): " + (x < 15));
        return x < 15;
    }
    public static void in(int x) {
        spaces();
        System.out.println("(" + x + ")->");
        depth++;
    }
    public static void out(int x) {
        depth--;
        spaces();
        System.out.println("<-(" + x + ")");
    }
    private static void spaces() {
        for (int k = 0; k < depth; k++) {
            System.out.print("   ");
        }
    }
}