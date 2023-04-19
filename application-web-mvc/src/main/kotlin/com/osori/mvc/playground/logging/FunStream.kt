package com.osori.mvc.playground.logging

sealed class FunStream<out A> {

    object Nil : FunStream<Nothing>()
    data class Cons<out A>(val head: () -> A, val tail: () -> FunStream<A>) : FunStream<A>() {
        override fun equals(other: Any?): Boolean =
            if (other is Cons<*>) {
                if (head() == other.head()) {
                    tail() == other.tail()
                } else {
                    false
                }
            } else {
                false
            }

        override fun hashCode(): Int {
            var result = head.hashCode()
            result = 31 * result + tail.hashCode()
            return result
        }
    }

    //
    //    override infix fun <B> flatMap(f: (A) -> Monad<B>): FunStream<B> = when (this) {
    //        FunStream.Nil -> Nil
    //        is FunStream.Cons -> f(head()) as FunStream<B> mappend tail().flatMap(f)
    //    }
    //
    //    infix fun <B> leadTo(m: FunStream<B>): FunStream<B> = flatMap { m }

}

fun <T> funStreamOf(vararg elements: T): FunStream<T> = elements.toFunStream()

private fun <T> Array<out T>.toFunStream(): FunStream<T> = when {
    this.isEmpty() -> FunStream.Nil
    else -> FunStream.Cons({ this[0] }, { this.copyOfRange(1, this.size).toFunStream() })
}

infix fun <T, R> FunStream<T>.fmap(f: (T) -> R): FunStream<R> = when (this) {
    FunStream.Nil -> FunStream.Nil
    is FunStream.Cons -> FunStream.Cons({ f(head()) }, { tail().fmap(f) })
}