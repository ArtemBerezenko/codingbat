package com.company.Hackerrank.SherlockAndAnagrams

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {
    val map = mutableMapOf<String, Int>()
    for (i in 0 until s.length) {
        for (j in i + 1 .. s.length) {
            val chars = s.substring(i, j).toCharArray()
            Arrays.sort(chars)
            val sorted = String(chars)
            if (map.containsKey(sorted)) {
                map[sorted] = map[sorted]!!.toInt() + 1
            } else {
                map[sorted] = 1
            }
        }
    }
    var sum = 0
    for (value in map.values) {
        sum += (value * (value - 1) / 2)
    }
    return sum
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
