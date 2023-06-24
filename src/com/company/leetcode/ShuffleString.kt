package com.company.leetcode

class ShuffleString

fun restoreString(s: String, indices: IntArray): String {
    val resultArray = arrayOfNulls<String>(indices.size)

    for (i in 0 until indices.size) {
        val index = indices[i]
        resultArray[index] = s[i].toString()
    }

    return resultArray.joinToString(separator = "")
}

fun main() {
    println(restoreString("codeleet", intArrayOf(4,5,6,7,0,2,1,3)))
}