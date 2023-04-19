package com.osori.mvc.playground.monad

interface Functor<out A> {
    fun <B> fmap(f: (A) -> B): Functor<B>
}