package com.company.Hackerrank.recursion.davisStaircase

import java.util.*

fun stepPerms(n: Int,  map: MutableMap<Int, Int>): Int {
    if (n == 1) return 1
    if (n == 2) return 2
    if (n == 3) return 4
    if (map.containsKey(n))
        return map.getValue(n)
    var res = 0
    res += stepPerms(n - 1, map)
    res += stepPerms(n - 2, map)
    res += stepPerms(n - 3, map)
    map[n] = res
    return res
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine().trim().toInt()

    for (sItr in 1..s) {
        val n = scan.nextLine().trim().toInt()

        val res = stepPerms(n, mutableMapOf())

        println(res)
    }
}
