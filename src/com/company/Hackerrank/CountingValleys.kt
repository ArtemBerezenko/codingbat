package com.company.Hackerrank

import java.util.*

fun countingValleys(n: Int, s: String): Int {
    var count = 0
    var counter = 0
    for (i in 0 until s.length) {
        val str = s.substring(i, i + 1)
        if (str == "U") counter++ else counter--
        if (counter == 0 && str != "D") count++
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
