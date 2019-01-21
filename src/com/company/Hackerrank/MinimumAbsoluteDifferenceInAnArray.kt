package com.company.Hackerrank

import java.util.*

fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    val array = arr.sortedArray()
    var min = 0
    for (i in 0 until array.size - 1) {
        if (i == 0) min = array[i + 1] - array[i]
        else if (array[i + 1] - array[i] < min) min = array[i + 1] - array[i]
    }
    return min
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)

    println(result)
}
