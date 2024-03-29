package com.osori.mvc.playground.logging

import com.osori.mvc.playground.logging.funStreamOf


fun main() {
    functionalFunction(funStreamOf(1, 2, 3))

    println("**** Log in higher order function ****")
    val result1 = functionalSolution1(funStreamOf(1, 2, 3))
    println(funStreamOf(result1))

    println("**** Log in extension function ****")
    val result2 = functionalSolution2(funStreamOf(1, 2, 3))
    println(printFunStream(result2))
}

private fun functionalFunction(list: FunStream<Int>) = list
    .fmap { it + 5 }
    .fmap { it * it }
    .fmap { it > 50 }

private fun functionalSolution1(list: FunStream<Int>) = list
    .fmap {
        println("$it + 5")
        it + 5
    }
    .fmap {
        println("$it * $it")
        it * it
    }
    .fmap {
        println("$it > 50")
        it > 50
    }

private fun functionalSolution2(list: FunStream<Int>) = list
    .fmap { addFive(it) withLog "$it + 5" }
    .fmap { square(it) withLog "$it * $it" }
    .fmap { isGreaterThan50(it) withLog "$it > 50" }

private fun addFive(it: Int) = it + 5

private fun square(it: Int) = it * it

private fun isGreaterThan50(it: Int) = it > 50

private infix fun <T> T.withLog(log: String): T {
    println(log)
    return this
}

fun <T> printFunStream(stream: FunStream<T>): Unit = println(stream.toStringByFoldLeft())

private fun <T> FunStream<T>.toStringByFoldLeft(acc: String = ""): String = when (this) {
    FunStream.Nil -> "[${acc.drop(2)}]"
    is FunStream.Cons -> tail().toStringByFoldLeft(acc + ", " + head())
}