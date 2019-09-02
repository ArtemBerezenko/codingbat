package com.company.Hackerrank.recursion.davisStaircase

import java.util.*

private val map = mutableMapOf<Int, Int>()

fun stepPerms2(n: Int): Int {
    if (n < 0) return 0
    if (n == 0) return 1
    if (!map.containsKey(n)) {
        val count = stepPerms2(n - 1) + stepPerms2(n - 2) + stepPerms2(n - 3)
        map[n] = count
    }
    return map[n]!!
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine().trim().toInt()

    for (sItr in 1..s) {
        val n = scan.nextLine().trim().toInt()

        val res = stepPerms2(n)

        println(res)
    }
}