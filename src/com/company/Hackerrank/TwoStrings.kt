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

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
    for (i in 0 until s1.length) {
        if (s2.contains(s1[i])) {
            return "YES"
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextInt()

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine().trim()

        val s2 = scan.nextLine().trim()

        val result = twoStrings(s1, s2)

        println(result)
    }
}