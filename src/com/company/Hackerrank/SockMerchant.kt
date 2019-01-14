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

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val map = mutableMapOf<Int, Int?>()
    var pairs = 0
    for (i in 0 until ar.size) {
        if (map.containsKey(ar[i])) {
            map[ar[i]] = map[ar[i]]?.plus(1)
        } else {
            map.put(ar[i], 1)
        }
    }
    map.values.forEach{ value ->
        if (value != null) {
            if (value == 2) {
                pairs += 1
            } else if (value > 2) {
                pairs += value / 2
            }
        }
    }
    return pairs
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
