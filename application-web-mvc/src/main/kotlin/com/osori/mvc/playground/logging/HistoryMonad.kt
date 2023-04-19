package com.osori.mvc.playground.logging

import com.osori.mvc.playground.monad.Monad


fun main() {

    val history = HistoryMonad.pure(3)
        .flatMap { x -> HistoryMonad.pure(addFive(x)) withLog "응 처음은 8 저장이야" }
        .flatMap { x -> HistoryMonad.pure(square(x)) withLog "응 처음은 64 저장이야" }

    println(history);
    val x = 10
    val f = { a: Int -> HistoryMonad.pure(a * 2) }
    val g = { a: Int -> HistoryMonad.pure(a + 1) }
    val pure = { a: Int -> HistoryMonad.pure(a) }
    val m = HistoryMonad.pure(10)

    // Left Identity
    // pure(x) flatMap f = f(x)
    println(pure(x) flatMap f == f(x))  // true

    // Right Identity
    // m flatMap pure = m
    println(m flatMap pure == m)    // true

    // Associativity Law
    // (m flatMap f) flatMap g = m flatMap { x -> f(x) flatMap g }
    println((m flatMap f) flatMap g == m flatMap { a -> f(a) flatMap g })  // true
}

private fun addFive(it: Int) = it + 5

private fun square(it: Int) = it * it

private fun isGreaterThan50(it: Int) = it > 50

data class HistoryMonad<out A>(val current: A, val history: List<String>) : Monad<A> {
    companion object {
        fun <V> pure(value: V): HistoryMonad<V> {
            return HistoryMonad(value, listOf())
        }
    }

    override fun <V> pure(value: V): HistoryMonad<V> {
        return HistoryMonad(value, listOf())
    }

    override fun <B> flatMap(f: (A) -> Monad<B>): HistoryMonad<B> {
        val current1 = f(current) as HistoryMonad<B>
        return HistoryMonad(current1.current, this.history + current1.history)
    }

    override fun toString(): String {
        return "HistoryMonad(current=$current, history=$history)"
    }

    infix fun withLog(log: String): HistoryMonad<A> {
        return HistoryMonad(this.current, listOf(log));
    }
}
