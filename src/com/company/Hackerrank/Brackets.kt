package com.company.Hackerrank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the isBalanced function below.
fun isBalanced(s: String): String {
    val stack = Stack<String>().apply {
        s.forEach {
            this.push(it.toString())
        }
    }

    return if (isBalancedSequence(stack)) "YES" else "NO"
}


private fun isBalancedSequence(stack: Stack<String>,
                               bracketIndex: Int = 0,
                               index: Int = 0): Boolean {
    val brackets = createBracketsMap()
    val bracket = stack[bracketIndex]
    if (stack.isEmpty() || index == stack.size) {
        return stack.isEmpty()
    } else if (stack.elementAt(index) == brackets[bracket]) {
        stack.removeAt(index)
        stack.removeAt(bracketIndex)
        if (stack.isNotEmpty()) {
            if (index >= 2) {
                return isBalancedSequence(stack, index - 2, index - 1)
            } else {
                return isBalancedSequence(stack, index - 1, index)
            }
        }
    } else {
        if (stack.isNotEmpty())
            return isBalancedSequence(stack, index, index + 1)
    }
    return stack.isEmpty()
}


private fun createBracketsMap() = mutableMapOf<String, String>().also { map ->
    map["{"] = "}"
    map["["] = "]"
    map["("] = ")"
}


fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val s = scan.nextLine()

        val result = isBalanced(s)

        println(result)
    }
}
