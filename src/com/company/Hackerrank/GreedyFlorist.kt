package com.company.Hackerrank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the getMinimumCost function below.
fun getMinimumCost(k: Int, c: Array<Int>): Int {
    var numberOfFriends = k
    var flowers: Array<Int> = c.sortedArrayDescending()
    var overpricing = 0
    var amount = 0
    while (flowers.isNotEmpty()) {
        if (numberOfFriends == 0) {
            numberOfFriends = k
            overpricing++
        }
        amount += (overpricing + 1) * flowers.first()
        flowers = flowers.drop(1).toTypedArray()
        numberOfFriends--
    }

    return amount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
}