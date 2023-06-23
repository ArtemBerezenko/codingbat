package com.company.leetcode

fun shuffle(nums: IntArray, n: Int): IntArray {
    var l = 0;
    var r = n
    val result = IntArray(2 * n)

    var i = 0
    while (l != n && r != nums.size) {
        result[i++] = nums[l++]
        result[i++] = nums[r++]
    }

    return result
}

fun main() {
    println(shuffle(intArrayOf(2,5,1,3,4,7), 3))
}
