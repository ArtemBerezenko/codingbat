package com.company.Hackerrank


fun countTriplets1(arr: Array<Long>, r: Long): Long {
    val set = mutableSetOf<LongArray>()
    val current = LongArray(3)
    var count = 0
    for (i in 0 .. arr.size - 3) {
        for (j in i + 1 until arr.size) {
            if (count <= 3) {
                if (arr[j] / (arr[j - 1]) == r) {
                    current[count++]
                }
            } else {
                set.add(current)
                count = 0
            }

        }
    }
    return set.size.toLong()
}


fun countTriplets2(arr: Array<Long>, r: Long): Long {
    val map = mutableMapOf<Long, MutableList<Long>>()
    var count = 0
    var result = 0;
    arr.asSequence().forEachIndexed { i, key ->
        if (map.containsKey(key)) {
            map[key]?.add(i.toLong())
        } else {
            map[key] = mutableListOf(i.toLong())
        }
    }
    return result.toLong()
}

fun countTriplets(arr: Array<Long>, r: Long): Long {
    val t2: MutableMap<Long, Long?> = HashMap()
    val t3: MutableMap<Long, Long> = HashMap()
    var result = 0L
    for (a in arr) {
        result += t3.getOrDefault(a, 0L)
        if (t2.containsKey(a)) {
            t3[a * r] = t3.getOrDefault(a * r, 0L) + t2[a]!!
        }
        t2[a * r] = t2.getOrDefault(a * r, 0L)!! + 1
    }
    return result
}

fun main() {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
