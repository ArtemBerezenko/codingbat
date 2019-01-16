package com.company.Hackerrank

import java.io._

object Solution {

  // Complete the sherlockAndAnagrams function below.
  def sherlockAndAnagrams(s: String): Int =
    (1 until s.length).map(l => solve(s, l)).sum

  def solve(s: String, len: Int): Int =
    (0 to s.length - len).
      map(i => s.substring(i, i + len).sortWith((a, b) => a < b)).
      groupBy(x => x).map(_._2.size).filter(_ > 1).
      map(x => x * (x - 1) / 2).sum

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = stdin.readLine

      val result = sherlockAndAnagrams(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}