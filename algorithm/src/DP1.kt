tailrec fun factorial_plus_n(n: Int, acc: Int): Int {
    return if (n <= 0) {
        acc
    } else {
        factorial_plus_n(n-1, n*acc)
    }
}

fun main() {
    println()
    println(factorial_plus_n(4,10))
}