package com.company.Hackerrank

import java.util.*

fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    val important = contests.filter { it[1] > 0 }.sortedBy { it[0] }
    var numberOfWins = important.size - k
    val min = mutableListOf<Array<Int>>()
    var i = 0
    while (numberOfWins > 0) {
        min.add(important[i++])
        numberOfWins--
    }
    var sum = 0
    var subtract = 0
    for (item in contests) {
       if (!min.contains(item)) {
           sum += item[0]
       } else subtract += item[0]
    }
    return sum - subtract
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        contests[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}