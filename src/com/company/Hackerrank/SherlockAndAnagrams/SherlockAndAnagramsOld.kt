package com.company.Hackerrank.SherlockAndAnagrams

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*
>import kotlin.collections.ArrayList

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagramsOld(s: String): Int {
    var count = 0
    val map = mutableMapOf<String, ArrayList<String>>()
    var words: MutableMap<String, ArrayList<String>>
    for (i in 0 until s.length) {
        val listLetters = findLetters(i, s)
        if (listLetters.isNotEmpty()) {
            if (!map.containsKey(s[i].toString())) {
                map[s[i].toString()] = arrayListOf()
            }
            map[s[i].toString()]?.addAll(findLetters(i, s))
        }
    }
    for (i in 0 until s.length / 2 ) {
        for (j in 2 .. s.length / 2 + 1) {
            val substring = s.substring(i, i + j)
            words = findPairs(substring, s, i)
            if (words.isNotEmpty()) {
                if (map.containsKey(substring)) {
                    map[substring]?.addAll(words[substring] as Iterable<String>)
                } else {
                    map.putAll(words)
                }
            }
        }
    }
    for (item in map) {
        count += item.value.size
    }
    return count
}

fun contains(index: Int, string: String): Boolean {
    val char = string.substring(index, index + 1)
    string.forEachIndexed { i, str ->
        if (char == str.toString() && index != i)
            return true
    }
    return false
}

fun findLetters(index: Int, string: String): ArrayList<String> {
    val list = arrayListOf<String>()
    val char = string.substring(index, index + 1)
    string.forEachIndexed { i, str ->
        if (char == str.toString() && i > index) {
            list.add(char)
        }
    }
    return list
}

fun findPairs(substr: String, string: String, index: Int): MutableMap<String, ArrayList<String>> {
    val map = mutableMapOf<String, ArrayList<String>>()
    for (i in index + 1 .. string.length - substr.length) {
        if (isAnagram(substr, string.substring(i, i + substr.length))) {
            if (!map.containsKey(substr)) {
                map[substr] = arrayListOf()
            }
            map[substr]?.addAll(arrayListOf(string.substring(i, i + substr.length)))
        }
    }
    return map
}

fun isAnagram(str1: String, str2: String): Boolean {
    if (str1 == str2) return true
    var string = str2
    for (i in 0 until str1.length) {
        string = cutSubstIfContains(str1.substring(i, i + 1), string)
    }
    if (string.isEmpty()) {
        return true
    }
    return false
}

fun cutSubstIfContains(substr: String, string: String): String {
    val str = StringBuilder()
    var isContain = false
    for (i in 0 until string.length) {
        if (!isContain && substr == string.substring(i, i + 1)) isContain = true
        else str.append(string.substring(i, i + 1))
    }
    return str.toString()
}

fun solution(s: String): Int {
    val map = mutableMapOf<String, Int>()
    for (i in 0 .. s.length) {
        for (j in i + 1 .. s.length) {
            val str = s.substring(i, j).chars()
            val sortStr = str.sorted().toString()
            if (map.containsKey(sortStr)) {
                map[sortStr]?.plus(1)
            } else map[sortStr] = 1
        }
    }
    var sum = 0
    for (value in map.values) {
        sum += (value * (value - 1) / 2)
    }
    return sum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = solution(s)

        println(result)
    }
}
