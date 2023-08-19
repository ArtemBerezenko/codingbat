package com.company.zalando

fun solution(N_arg: Int) {
    var N: Int = N_arg
    var enable_print: Int

    enable_print = N % 10
    while (N > 0) {
//        if (enable_print == 0 && N % 10 != 0) {
//            enable_print = 1
//        } else if (enable_print == 1) {
//            print(N % 10)
//        }
        if (enable_print == 0 && N % 10 != 0) {
            print(N % 10)
        } else if (enable_print == 1) {
            print(N % 10)
        }
        N = N / 10
    }
}


fun solution(AA: Int, AB: Int, BB: Int): String {
    var aa = AA
    var ab = AB
    var bb = BB
    val ans = StringBuilder()

    while (aa > 0 || bb > 0 || ab > 0) {
        var writeA = false
        var writeAB = false

        if (ans.length >= 2) {
            if (ans[ans.length - 1] != ans[ans.length - 2] && ab > 0) {
                writeAB = true
            } else if (ans[ans.length - 1] == 'B') {
                writeA = true
            }
        } else {
            if (ab >= aa && ab != 0) {
                writeAB = true
            } else if (aa >= bb) {
                writeA = true
            }
        }

        if (writeAB) {
            if (ab > 0) {
                ab--
                ans.append("AB")
            }
        } else if (writeA) {
            if (aa > 0) {
                aa--
            } else {
                break
            }
            ans.append("AA")

        } else {
            if (bb > 0) {
                bb--
            } else {
                break
            }
            ans.append("BB")
        }
    }

    return ans.toString()
}

fun solution(S: String): String {
    var str = S

    while (str.isNotEmpty() && isAbleToTransform(str)) {
        str = str.replace("AB", "")
        str = str.replace("BA", "")
        str = str.replace("CD", "")
        str = str.replace("DC", "")
    }

    return str
}

private fun isAbleToTransform(str: String): Boolean =
    (str.contains("AB") || str.contains("BA") || str.contains("CD") || str.contains("DC"))

fun main() {
//    print(solution(0))
//    print(solution(0, 0, 10))
    println(solution("BBBBBAAA"))
}