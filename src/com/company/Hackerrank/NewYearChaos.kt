package com.company.Hackerrank

import java.util.*
import kotlin.math.max

fun minimumBribes1(q: Array<Int>) {
    var count = 0
    var toMuch = false
    for (i in 0 until q.size) {
        when (q[i]) {
            i + 2 -> count++
            i + 3 -> count += 2
            i + 1 -> count = checkNeighbors(i, q, count)
            i -> count = checkNeighbors(i, q, count)
            else -> {
                if (q[i] > i + 1) {
                    toMuch = true
                }
            }
        }
    }
    if (!toMuch) {
        println("${count}\n")
    } else {
        println("Too chaotic")
    }
}

fun checkNeighbors(i: Int, q: Array<Int>, count: Int): Int {
    var count1 = count
    if (i + 1 <= q.size - 1 && q[i] >= q[i + 1]) {
        count1++
    }
    if (i + 2 <= q.size - 1 && q[i] >= q[i + 2]) {
        count1++
    }
    return count1
}

fun minimumBribes(q: Array<Int>) {
    var result = 0
    for (i in q.size - 1 downTo 0) {
        if (q[i] - (i + 1) > 2) {
            println("Too chaotic")
            return
        }
        for (j in max(0, q[i] - 2) until i) {
            if (q[j] > q[i]) {
                result++
            }
        }
    }
    println("${result}\n")
}

fun max(a: Int, b: Int) {
    if (a >= b) a else b
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
