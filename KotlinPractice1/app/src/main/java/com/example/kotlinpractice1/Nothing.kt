package com.example.kotlinpractice1


fun main(){
    println(Either.Left("가나다"))
}


/*fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}*/
fun <A,B,C> ((A)->B).c(f:(B) -> C): (A) ->C = {
    f(this(it))
}

 sealed class Either<out L, out R> {
    data class Left<out L>(val a: L) : Either<L, Nothing>()
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight: Boolean
        get() = this is Right<R>

    val isLeft: Boolean
        get() = this is Left<L>
}

fun <L> left(a: L) = Either.Left(a)
fun <R> right(b: R) = Either.Right(b)

fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Either.Left -> Either.Left(a)
        is Either.Right -> fn(b)
    }

fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.c(::right))

fun <T, L, R> Either<L, R>.either(fnL: (L) -> T, fnR: (R) -> T): T =
    when (this) {
        is Either.Left -> fnL(a)
        is Either.Right -> fnR(b)
    }
