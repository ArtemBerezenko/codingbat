package com.company.Hackerrank

import java.util.*

class ATaleOfTwoStacksKotlin {
    class Queue<T> {
        val stackNewestOnTop: Stack<T> = Stack()
        val stackOldestOnTop: Stack<T> = Stack()

        fun enqueue(value: T) {
            stackNewestOnTop.push(value)
        }

        fun peek(): T {
            var value: T? = null
            if (!stackOldestOnTop.isEmpty()) {
                value = stackOldestOnTop.firstElement()
            }
            return value!!
        }

        fun dequeue(): T? {
            if (!stackOldestOnTop.isEmpty()) {
                val value: T = stackOldestOnTop.lastElement()
                stackOldestOnTop.remove(stackOldestOnTop.lastElement())
                if (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.add(stackNewestOnTop.firstElement())
                    stackNewestOnTop.remove(stackNewestOnTop.firstElement())
                }
                return value
            }
            return null
        }


    }

    fun main(args: Array<String>) {
        val queue: Queue<Int> = Queue()

        val scan: Scanner = Scanner(System.`in`)
        val numQueue: Int = scan.nextInt()

        for (i in 0 .. numQueue - 1) {
            val operatror: Int = scan.nextInt()
            if (operatror == 1) {
                queue.enqueue(scan.nextInt())
            } else if (operatror == 2) {
                queue.dequeue()
            } else if (operatror == 3) {
                print(queue.peek())
            }
        }
        scan.close()
    }
}