package com.osori.mvc.playground.logging

import com.osori.mvc.playground.monad.Monad


fun main() {
    //Functional Logging 인데, 실행 중에 출력하지 않고

    val history = TestMonad.pure(3)
        .flatMap { x -> TestMonad.pure(addFive(x)) withLog "처음은 8 저장이야" }
        .flatMap { x -> TestMonad.pure(square(x)) withLog "처음은 64 저장이야" }
        .flatMap { x -> TestMonad.pure(isGreaterThan50(x)) withLog "50 이상이다" }

    //[응 처음은 8 저장이야, 응 처음은 64 저장이야, 50 이상이다]
    print(history.history)
}

private fun addFive(it: Int) = it + 5

private fun square(it: Int) = it * it

private fun isGreaterThan50(it: Int) = it > 50

data class TestMonad<out A>(val current: A, val history: List<String>) : Monad<A> {
    companion object {
        fun <V> pure(value: V): TestMonad<V> {
            return TestMonad(value, listOf())
        }
    }

    override fun <V> pure(value: V): TestMonad<V> {
        return TestMonad(value, listOf())
    }

    override fun <B> flatMap(f: (A) -> Monad<B>): TestMonad<B> {
        val current1 = f(current) as HistoryMonad<B>
        return TestMonad(current1.current, this.history + current1.history)
    }

    override fun toString(): String {
        return "HistoryMonad(current=$current, history=$history)"
    }
}
