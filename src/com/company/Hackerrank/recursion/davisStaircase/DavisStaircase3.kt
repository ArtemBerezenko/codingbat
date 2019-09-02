package com.company.Hackerrank.recursion.davisStaircase

import java.util.*

private val map = mutableMapOf<Int, Int>()

fun stepPerms3(n: Int): Int {
    if (n < 0) return 0
    if (n == 0) return 1
    return map.computeIfAbsent(n) { stepPerms3(n - 1) + stepPerms3(n - 2) + stepPerms3(n - 3) }
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine().trim().toInt()

    for (sItr in 1..s) {
        val n = scan.nextLine().trim().toInt()

        val res = stepPerms3(n)

        println(res)
    }
}