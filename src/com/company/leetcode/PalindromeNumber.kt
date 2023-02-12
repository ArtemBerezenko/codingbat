package com.company.leetcode


fun isPalindrome(x: Int): Boolean {
    var remainder = x
    var reverse = 0
    while (remainder > 0) {
        reverse = reverse * 10 + remainder % 10
        remainder /= 10
    }
    return x == reverse
}

fun main() {
    isPalindrome(121)
}