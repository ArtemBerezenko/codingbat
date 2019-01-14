package com.company.Hackerrank

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the repeatedString function below.
fun repeatedString1(s: String, n: Long): Long {
    var count = 0
    var i = 0
    var j = 0
    var equalizer = 0
    while (i < n) {
        if (j == s.length) {
            j = 0
            equalizer += s.length
        }
        if (s.substring(i - equalizer, i - equalizer + 1).toLowerCase() == "a") {
            count++
        }
        j++
        i++
    }
    return count.toLong()
}

fun repeatedString(s: String, n: Long): Long {
    var count = 0L
    for (i in 0 until s.length) {
        if (s.substring(i, i + 1).toLowerCase() == "a") {
            count++
        }
    }
    val num = n / s.length
    count *= num
    val remainder = (n % s.length).toInt()
    for (i in 0 until remainder) {
        if (s.substring(i, i + 1).toLowerCase() == "a") {
            count++
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
