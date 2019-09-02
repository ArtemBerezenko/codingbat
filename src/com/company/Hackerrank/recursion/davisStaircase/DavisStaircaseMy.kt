package com.company.Hackerrank.recursion.davisStaircase

import java.util.*


fun stepPermsMy(n: Int): Int {
    val variants = arrayOf(1, 2, 3)
    var ways = mutableListOf<Array<Int?>>()
    var array = arrayOfNulls<Int>(n)
    for (i in variants.indices) {
        var index = 0
        when (variants[i]) {
            1 -> {
                while (index < n) {
                    array[index++] = variants[0]
                }
                ways.add(array)
            }
            2 -> {
                if (n >= 2) {
                    var sum = 0
                    while (true) {
                        sum = 0
                        index++
                        array = array.dropLast(1).toTypedArray()
                        var j = 1
                        while (j <= index && j <= array.size - 1) {
                            array[array.size - j] = 2
                            j++
                        }
                        array.forEach { sum += it!! }
                        if (sum == n) {
                            ways.add(array)
                            ways = findWays(ways, array, array.size - 1)
                        } else
                            break
                    }
                }
            }
            3 -> {
                if (n >= 3) {
                    var sum = 3
                    val list = mutableListOf<Int>()
                    list.add(3)
                    while (sum < n) {
                        list.add(variants[0])
                        sum += variants[0]
                    }
                    list.sort()
                    array = list.toTypedArray()
                    ways.add(array)
                    ways = findWays(ways, array, array.size)
                    for (k in variants.size - 1 downTo 1) {
                        var arr = checkPretender(array, variants[k])
                        while (arr.isNotEmpty()) {
                            ways.add(arr)
                            ways = findWays(ways, arr, arr.size)
                            arr = checkPretender(arr, variants[k])
                        }
                    }
                }
            }
        }
    }
    return ways.size
}

fun checkPretender(array: Array<Int?>, pretender: Int): Array<Int?> {
    val list = mutableListOf<Int>()
    if (array.size - pretender > 0) {
        val arr = array.drop(pretender).toTypedArray()
        arr.forEach { list.add(it!!) }
        list.add(pretender)
        list.sort()
    }
    return list.toTypedArray()
}

fun findWays(list: MutableList<Array<Int?>>, variants: Array<Int?>, index: Int): MutableList<Array<Int?>> {
    var listR = list.toMutableList()
    if (index == 0) return listR
    var array = variants.copyOf()
    for (i in variants.size - 1 downTo 1) {
        val temp = array[i - 1]
        array[i - 1] = array[i]
        array[i] = temp
        val isNotPresented = listR.find { it.contentDeepEquals(array) } == null
        if (isNotPresented) {
            listR.add(array)
            array = array.copyOf()
        } else if (i == 1) {
            array = list.last()
        }
    }
    if (array.last() != 1 && index >= 0) {
        listR = findWays(listR, array, index - 1)
    } else if (variants.contains(2) && variants.contains(3) && index != 1) {
        listR = findWays(listR, array, index)
    }
    return listR
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine().trim().toInt()

    for (sItr in 1..s) {
        val n = scan.nextLine().trim().toInt()

        val res = stepPermsMy(n)

        println(res)
    }
}
