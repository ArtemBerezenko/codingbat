package com.company.Examples.Trees

import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val root = BSTree.Node<Int>(scanner.nextInt())

    while (scanner.hasNextInt()) {
        val value = scanner.nextInt()
        root.insert(value)
    }
    scanner.close()

    root.printInOrder()
}


