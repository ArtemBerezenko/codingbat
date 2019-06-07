package com.company.Geeksforgeeks

import java.util.*
import java.util.stream.Collectors




fun <T> removeDuplicates(list: ArrayList<T>): ArrayList<T> {
    val newList = ArrayList<T>()
    for (element in list) {
        if (!newList.contains(element)) {
            newList.add(element)
        }
    }
    return newList
}

fun <T> trickyRemoveDuplicates(list: ArrayList<T>): ArrayList<T> {

    val set = LinkedHashSet<T>()

//    val set2 = HashSet<T>(list)

    set.addAll(list)

    list.clear()

    list.addAll(set)

    return list
}

fun main() {

    val list = arrayListOf(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5)

    println("ArrayList with duplicates: $list")

    val newList = trickyRemoveDuplicates(list)

    val newList2 = list.stream()
            .distinct()
            .collect(Collectors.toList())

    val newlist3 = list.distinct()

    println("ArrayList with duplicates removed: $newList")
    println("ArrayList with duplicates removed: $newList2")
    println("ArrayList with duplicates removed: $newlist3")


}

