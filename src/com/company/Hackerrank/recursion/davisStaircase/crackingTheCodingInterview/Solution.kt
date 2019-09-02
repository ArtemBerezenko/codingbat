package com.company.Hackerrank.recursion.davisStaircase.crackingTheCodingInterview

import java.util.*

fun countPaths(steps: Int): Int {//slowly solution
    if (steps < 0) return 0
    else if (steps == 0) return 1
    return countPaths(steps - 1) + countPaths(steps - 2) + countPaths(steps - 3)
}

fun countPathsMemo(steps: Int): Int {//with memoization
    if (steps < 0) return 0
    return countPathsMemo(steps, arrayOf(steps + 1))
}

fun countPathsMemo(steps: Int, memo: Array<Int>): Int {
    if (steps < 0) return 0
    else if (steps == 0) return 1
    if (memo[steps] == 0) {
        memo[steps] = countPathsMemo(steps - 1, memo) + countPathsMemo(steps - 2, memo) + countPathsMemo(steps - 3, memo)
    }
    return memo[steps]
}

fun countPathsDP(steps: Int): Int? {// with Dynamic Programming
    if (steps < 0) return 0
    else if (steps <= 1) return 1
    val paths = arrayOfNulls<Int>(steps + 1)
    paths[0] = 1
    paths[1] = 1
    paths[2] = 2
    for (i in 3 .. steps) {
        paths[i] = paths[i - 1]!! + paths[i - 2]!! + paths[i - 3]!!
    }
    return paths[steps]
}

fun countPathsI(steps: Int): Int? {// Iterative
    if (steps < 0) return 0
    else if (steps <= 1) return 1
    val paths = arrayOf(1, 1, 2)
    for (i in 3 .. steps) {
        val count = paths[2] + paths[1] + paths[0]
        paths[0] = paths[1]
        paths[1] = paths[2]
        paths[2] = count
    }
    return paths[2]
}

fun main() {
    val scan = Scanner(System.`in`)
    val s = scan.nextLine().trim().toInt()

    for (sItr in 1..s) {
        val n = scan.nextLine().trim().toInt()

        val res = countPaths(n)
        println(res)

        val res1 = countPathsMemo(n)
        println(res1)

        val res2 = countPathsDP(n)
        println(res2)

        val res3 = countPathsI(n)
        println(res3)
    }
}