package com.company.Examples.Trees

import java.util.*

class BSTree {
    lateinit var queue: Queue<Node<Int>>

    class Node<T : Comparable<T>>(var data: T) {
        var left: Node<T>?
        var right: Node<T>?

        init {
            this.left = null
            this.right = null
        }

        /** Insert new values into the tree.
         * @param value The data value for the node to insert.
         */
        fun insert(value: T) {
            // value <= data
            if (value.compareTo(data) <= 0) {
                if (left == null) {
                    // Insert at empty subtree
                    left = Node(value)
                } else {
                    // Continue searching for empty subtree
                    left!!.insert(value)
                }
            } else { // value > data
                if (right == null) {
                    // Insert at empty subtree
                    right = Node(value)
                } else {
                    // Continue searching for empty subtree
                    right!!.insert(value)
                }
            }
        }

        /** Determines if the tree contains a specific value.
         * @param value The value to search the tree for.
         * @return True if tree contains value; otherwise, false.
         */
        operator fun contains(value: T): Boolean {
            return if (value.compareTo(data) == 0) {
                // Value found
                true
            } else if (value.compareTo(data) < 0) {
                if (left == null)
                    false // Not found; there are no more nodes in left subtree to check
                else
                    left!!.contains(value) // Continue searching left subtree
            } else { // data.compareTo(value) > 0
                if (right == null)
                    false // Not found; there are no more nodes in right subrtree to check
                else
                    right!!.contains(value) // Continue searching right subtree
            }
        }

        /** Print InOrder traversal of tree  */
        fun printInOrder() {
            if (left != null) {
                left!!.printInOrder()
            }

            print(data.toString() + " ")

            if (right != null) {
                right!!.printInOrder()
            }
        }
    }


    fun levelOrder(root: Node<Int>) {
        queue = Queue()
        //queue = Queue()
        queue.enqueue(root)

        while (!queue.isEmpty()) {
            val tree: Node<Int> = queue.dequeue()!!

            if (tree.left != null ) {
                queue.enqueue(tree.left!!)
            }
            if (tree.right != null) {
                queue.enqueue(tree.right!!)
            }
        }

    }

}

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
