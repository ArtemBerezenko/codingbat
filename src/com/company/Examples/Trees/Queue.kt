package com.company.Examples.Trees

import java.util.*

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

    fun isEmpty(): Boolean {
        if (!stackOldestOnTop.isEmpty())
            return true
        return false
    }
}