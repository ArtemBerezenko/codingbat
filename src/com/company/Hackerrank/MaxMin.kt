package com.company.Hackerrank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the maxMin function below.
fun maxMin(k: Int, arr: Array<Int>): Int {
    val array: Array<Int> = arr.sortedArray()
    var maxMin = 0
    for (i in 0..array.size - k) {
        val remainder = array[i + k - 1] - array[i]
        if (i == 0) {
            maxMin = remainder
        } else if (maxMin >= remainder) maxMin = remainder
    }
    return maxMin
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val k = scan.nextLine().trim().toInt()

    val arr = Array(n, { 0 })
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)
}