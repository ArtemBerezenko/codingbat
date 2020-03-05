package com.company.Hackerrank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the twoStrings function below.
fun twoStrings1(s1: String, s2: String): String {
    for (i in 0 until s1.length) {
        if (s2.contains(s1[i])) {
            return "YES"
        }
    }
    return "NO"
}

fun twoStrings(s1: String, s2: String): String {
    val set1 = mutableSetOf<Char>()
    val set2 = mutableSetOf<Char>()
    s1.asSequence().forEach { set1.add(it) }
    s2.asSequence().forEach { set2.add(it) }

    return if (set1.intersect(set2).isNotEmpty()) "YES" else "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextInt()

//    val q = scan.nextLine().trim().toInt()

    scan.nextLine()

    for (qItr in 1..n) {
        val s1 = scan.nextLine().trim()

        val s2 = scan.nextLine().trim()

        val result = twoStrings(s1, s2)

        println(result)
    }
}