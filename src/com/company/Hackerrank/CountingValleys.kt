package com.company.Hackerrank

import com.sun.xml.internal.fastinfoset.util.StringArray
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
